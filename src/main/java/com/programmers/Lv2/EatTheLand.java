package com.programmers.Lv2;

public class EatTheLand {
    public int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(max, land[i - 1][k]);
                    }
                }

                land[i][j] += max;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        EatTheLand eatTheLand = new EatTheLand();
        System.out.println(eatTheLand.solution(new int[][]{{1, 1, 1, 10}, {1, 1, 1, 21}, {1, 1, 1, 32}, {1, 1, 1, 43}, {1, 1, 1, 54}}));
    }
}
