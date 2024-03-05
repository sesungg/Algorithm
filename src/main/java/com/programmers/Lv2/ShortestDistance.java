package com.programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
    static class Position {
        int x;
        int y;
        int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }


    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.x == n - 1 && current.y == m - 1) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny, current.distance + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestDistance solution = new ShortestDistance();
        int[][] maps = {
                {1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1}
        };

        int result = solution.solution(maps);
        System.out.println(result); // 예상 출력: 11
    }

}
