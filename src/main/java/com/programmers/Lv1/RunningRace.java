package com.programmers.Lv1;

import java.util.*;

public class RunningRace {
    static class Solution {

        public String[] mySolution(String[] players, String[] callings) {
            String[] answer = new String[players.length];

            LinkedHashMap<String, Integer> playersKey = new LinkedHashMap();
            LinkedHashMap<Integer, String> rankingKey = new LinkedHashMap();

            for(int i = 0; i < players.length; i++) {
                playersKey.put(players[i], i);
                rankingKey.put(i, players[i]);
            }

            for(int i = 0; i < callings.length; i++) {
                // 호명 선수
                String calling = callings[i];

                // 호명한 선수의 순위
                int callPlayerRanking = playersKey.get(calling);
                // 추월당한 선수
                String frontPlayer = rankingKey.get(callPlayerRanking - 1);

                // 호명한 선수의 순위 -1
                playersKey.put(calling, callPlayerRanking - 1);
                // 추월당한 선수의 순위 +1
                playersKey.put(frontPlayer, callPlayerRanking);
                // 호명한 선수의 순위에 추월당한 선수 등록
                rankingKey.put(callPlayerRanking, frontPlayer);
                // 추월당한 선수의 순위에 호명한 선수 등록
                rankingKey.put(callPlayerRanking - 1, calling);
            }

            for(int i = 0; i < rankingKey.size(); i++) {
                answer[i] = rankingKey.get(i);
            }

            return answer;
        }

        class Node {
            String player;
            Node prev;
            Node next;
        }


        public String[] gptUpgradeSolution(String[] players, String[] callings) {
            Map<String, Node> playerMap = new HashMap<>();
            Node dummy = new Node();
            Node tail = dummy;

            // Create doubly linked list with players and map them
            for (String player : players) {
                Node node = new Node();
                node.player = player;
                tail.next = node;
                node.prev = tail;
                playerMap.put(player, node);
                tail = node;
            }

            // Process each calling
            for (String calling : callings) {
                Node node = playerMap.get(calling);
                if (node != dummy.next) {
                    Node prevNode = node.prev;

                    // Disconnect the node
                    prevNode.next = node.next;
                    if(node.next != null) {
                        node.next.prev = prevNode;
                    }

                    // Insert the node before its previous node
                    node.next = prevNode;
                    node.prev = prevNode.prev;
                    if(prevNode.prev != null) {
                        prevNode.prev.next = node;
                    }
                    prevNode.prev = node;
                }
            }

            // Convert the list back to an array
            int i = 0;
            Node node = dummy.next;
            while (node != null) {
                players[i++] = node.player;
                node = node.next;
            }

            return players;
        }
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = {"mumu", "kai", "mine", "soe", "poe"};

        Solution solution = new Solution();

        String[] mySolution = solution.mySolution(players, callings);
        String[] gptUpgradeSolution = solution.gptUpgradeSolution(players, callings);

        for(int i = 0; i < players.length; i++) {
            if (!mySolution[i].equals(result[i])) {
                System.out.println("내 코드 실패");
                break;
            }
        }
        for(int i = 0; i < players.length; i++) {
            if (!gptUpgradeSolution[i].equals(result[i])) {
                System.out.println("gpt 업글 코드 실패");
                break;
            }
        }

    }
}
