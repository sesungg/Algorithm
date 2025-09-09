package com.shortestPathAlgorithm.dijkstra;

import java.util.*;
import java.io.*;

public class DijkstraExample {

    // 간선(Edge) 클래스: 한 정점에서 다른 정점으로 가는 길(간선)을 표현
    static class Edge {
        int to; // 도착 정점 번호
        int w;  // 가중치(거리, 비용 등)
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    // 우선순위 큐에 넣을 노드 정보 (정점 번호, 현재까지의 최단 거리)
    static class Node implements Comparable<Node> {
        int v;     // 정점 번호
        int dist;  // 시작점에서 이 정점까지의 거리
        Node(int v, int dist) { this.v = v; this.dist = dist; }

        // 우선순위 큐에서 거리가 짧은 Node가 먼저 나오도록 정렬 기준 정의
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    // 다익스트라 결과를 담을 클래스
    static class Result {
        int[] dist; // 시작점으로부터 각 정점까지의 최단거리
        int[] prev; // 경로 복원을 위한 "부모 정점" 기록
        Result(int[] dist, int[] prev) {
            this.dist = dist;
            this.prev = prev;
        }
    }

    // 다익스트라 알고리즘 구현
    static Result dijkstra(int n, List<List<Edge>> graph, int src) {
        final int INF = 1_000_000_000; // 충분히 큰 값(무한대 대체용)
        int[] dist = new int[n];       // 최단거리 배열
        int[] prev = new int[n];       // 경로 복원 배열
        Arrays.fill(dist, INF);        // 초기에는 모두 무한대로 설정
        Arrays.fill(prev, -1);         // 부모 정점은 없으므로 -1로 초기화

        // 우선순위 큐(최소 힙): 거리가 가장 짧은 정점이 먼저 나옴
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[src] = 0;                 // 시작 정점 거리는 0
        pq.add(new Node(src, 0));      // 시작 정점을 큐에 추가

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 거리가 가장 짧은 정점을 꺼냄
            int u = cur.v;

            // 우선순위 큐에 있는 값이 "오래된 값"일 수 있으므로 체크
            if (cur.dist != dist[u]) continue;

            // u와 연결된 모든 간선을 확인
            for (Edge e : graph.get(u)) {
                int v = e.to;       // 인접 정점
                int nd = dist[u] + e.w; // u를 거쳐서 v로 가는 거리
                // 더 짧은 경로를 찾았다면 갱신
                if (nd < dist[v]) {
                    dist[v] = nd;   // 최단거리 갱신
                    prev[v] = u;    // 경로 추적을 위해 부모 정점 기록
                    pq.add(new Node(v, nd)); // 큐에 새 거리값 추가
                }
            }
        }
        return new Result(dist, prev); // 최종 거리와 경로 반환
    }

    // prev 배열을 이용해 src -> target까지의 경로를 복원하는 함수
    static List<Integer> buildPath(int target, int[] prev) {
        List<Integer> path = new ArrayList<>();
        for (int cur = target; cur != -1; cur = prev[cur]) {
            path.add(cur); // target에서 시작해 부모를 따라가며 경로 저장
        }
        Collections.reverse(path); // 거꾸로 저장되므로 반전
        return path;
    }

    // 실행 예제 (main 메서드)
    public static void main(String[] args) throws Exception {
        int n = 6; // 정점 개수: 0,1,2,3,4,5
        List<List<Edge>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>()); // 그래프 초기화

        // 그래프 구성 (양방향 그래프이므로 addEdge에서 undirected = true)
        addEdge(g, 0, 1, 7, true);
        addEdge(g, 0, 2, 9, true);
        addEdge(g, 0, 5, 14, true);
        addEdge(g, 1, 2, 10, true);
        addEdge(g, 1, 3, 15, true);
        addEdge(g, 2, 3, 11, true);
        addEdge(g, 2, 5, 2, true);
        addEdge(g, 3, 4, 6, true);
        addEdge(g, 4, 5, 9, true);

        int src = 0; // 시작 정점
        Result res = dijkstra(n, g, src); // 다익스트라 실행

        // 예시: 0번 → 4번까지의 최단거리와 경로 출력
        int target = 4;
        System.out.println("dist[4] = " + res.dist[target]);
        System.out.println("path = " + buildPath(target, res.prev));
    }

    // 그래프에 간선 추가 (무방향이면 양쪽에 추가)
    static void addEdge(List<List<Edge>> g, int u, int v, int w, boolean undirected) {
        g.get(u).add(new Edge(v, w));   // u → v 간선 추가
        if (undirected) g.get(v).add(new Edge(u, w)); // v → u 간선 추가
    }
}
