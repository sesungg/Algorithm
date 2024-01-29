package com.programmers.Lv2;

public class Carpet {
    public int[] mySolution(int brown, int yellow) {
        int total = brown + yellow;

        for (int i = 3; i <= total / i; i++) {
            if (total % i == 0) {
                int j = total / i;
                if ((i - 2) * (j - 2) == yellow) {
                    return new int[] {j, i};
                }
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        // 테스트 예시
        int[] result = carpet.mySolution(10, 2);
        System.out.println("[" + result[0] + ", " + result[1] + "]");  // [4, 3]

        result = carpet.mySolution(8, 1);
        System.out.println("[" + result[0] + ", " + result[1] + "]");  // [3, 3]

        result = carpet.mySolution(24, 24);
        System.out.println("[" + result[0] + ", " + result[1] + "]");  // [8, 6]

        result = carpet.mySolution(3004, 2996);
        System.out.println("[" + result[0] + ", " + result[1] + "]");  // [1500, 4]
    }
}