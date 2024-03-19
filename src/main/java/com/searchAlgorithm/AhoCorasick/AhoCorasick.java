package com.searchAlgorithm.AhoCorasick;

import java.util.*;

public class AhoCorasick {
    private final TrieNode root; // 트라이 구조의 시작점

    public AhoCorasick() {
        root = new TrieNode(); // root 노드 초기화
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>(); // 각 노드의 자식 노드를 저장하는 맵
        TrieNode failureNode; // 실패 링크를 저장하는 필드. 패턴 매칭 실패 시 다음으로 이동할 노드
        List<String> outputs = new ArrayList<>(); // 특정 노드에서 끝나는 모든 키워드를 저장하는 리스트
    }

    /**
     * 주어진 키워드들로 트라이를 구축하는 메소드
     *
     * @param keywords 금지어
     */
    public void buildTrie(String[] keywords) {
        for (String keyword : keywords) {
            TrieNode current = root; // 현재 노드를 루츠로 시작

            for (char ch : keyword.toCharArray()) {
                // 현재 노드의 자식 중에 현재 문자가 없으면 새 노드를 생성하고, 있으면 해당 노드를 가져옴
                current = current.children.computeIfAbsent(ch, c -> new TrieNode());
            }

            // 현재 노드에 키워드를 outputs 리스트에 추가.
            current.outputs.add(keyword);
        }
        // 실패 링크를 계산하는 메소드를 호출
        buildFailureLinks();
    }

    /**
     * 실패 링크를 계산하고 설정
     */
    private void buildFailureLinks() {
        Queue<TrieNode> queue = new LinkedList<>(); // BFS(너비 우선 탐색)을 위한 큐
        for (TrieNode depthOneNode : root.children.values()) { // 루트의 모든 직접적인 자식에 대해 반복
            depthOneNode.failureNode = root; // 루트의 직접적인 자식의 실패 링크는 루트 자신으로 설정
            queue.add(depthOneNode); // 큐에 자식 노드 추가
        }

        while (!queue.isEmpty()) { // 큐가 비어있지 않는 동안 반복
            TrieNode current = queue.remove(); // 큐에서 노드를 하나 꺼냄
            for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) { // 현재 노드의 모든 자식에 대해 반복
                TrieNode child = entry.getValue(); // 현재 자식 노드
                TrieNode failure = current.failureNode; // 현재 노드의 실패 링크
                // 실패 링크를 따라가면서 현재 문자가 있는 노드를 탐색
                while (failure != null && !failure.children.containsKey(entry.getKey())) {
                    failure = failure.failureNode;
                }
                // 실패 링크를 찾았으면 설정. 없으면 루트로 설정
                child.failureNode = (failure == null) ? root : failure.children.get(entry.getKey());
                // 실패 노드의 출력을 현재 자식 노드의 출력에 추가
                child.outputs.addAll(child.failureNode.outputs);
                queue.add(child); // 현재 자식 노드를 큐에 추가
            }
        }
    }

    /**
     * 주어진 텍스트에서 키워드를 검색하는 메소드
     *
     * @param text // 사용자가 입력한 문자열
     * @return // 검출된 단어
     */
    public List<String> search(String text) {
        List<String> matches = new ArrayList<>();
        TrieNode current = root; // 현재 노드를 루트로 시작
        for (char ch : text.toCharArray()) {
            // 현재 노드가 null이 아니면서 현재 문자에 해당하는 자식 노드가 없을 때까지 실패 링크를 추적
            while (current != null && !current.children.containsKey(ch)) {
                current = current.failureNode;
            }
            if (current == null) { // 현재 노드가 null이면 루트로 되돌린다.
                current = root;
                continue;
            }
            current = current.children.get(ch); // 현재 문자에 해당하는 자식 노드로 이동
            matches.addAll(current.outputs); // 현재 노드의 outputs을 추가
        }

        return matches;
    }

    public static void main(String[] args) {
        AhoCorasick ac = new AhoCorasick();
        String[] keywords = {"불닭볶음면", "라면", "소주", "맥주"};
        ac.buildTrie(keywords);
        String text = "이런저런거 시켜먹어봤는데 여기 아구찜이 최고인것같아요. 근데 불닭볶음면에 비하면 좀 부족하면 면이 있네요. 그래도 불닭맛은 조금 나요. 나중에 가면 라면도 해주세요. 소주에다가 먹으면..캬아";
        List<String> matches = ac.search(text);
        System.out.println("Found matches : " + matches);
    }
}
