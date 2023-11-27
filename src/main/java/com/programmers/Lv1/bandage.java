package com.programmers.Lv1;

public class bandage {

    private static int mySolution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int attackTime = 0;
        int castingTime = bandage[0];
        int secRecovery = bandage[1];
        int addRecovery = bandage[2];

        for (int[] attack : attacks) {
            attackTime = attack[0] - attackTime - 1;

            if (attackTime != 0) {
                if (attackTime < castingTime) {
                    answer += attackTime * secRecovery;
                } else {
                    answer += (attackTime * secRecovery) + (addRecovery * (attackTime / secRecovery));
                }

                if (answer > health) {
                    answer = health;
                }
            }

            answer = answer - attack[1];
            attackTime = attack[0];

            if (answer <= 0) {
                return -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] bandage1 = {5, 1, 5};
        int maxHealth1 = 30;
        int[][] attacks1 = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(mySolution(bandage1, maxHealth1, attacks1));  // Expected: 5

        int[] bandage2 = {3, 2, 7};
        int maxHealth2 = 20;
        int[][] attacks2 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println(mySolution(bandage2, maxHealth2, attacks2));  // Expected: -1

        int[] bandage3 = {4, 2, 7};
        int maxHealth3 = 20;
        int[][] attacks3 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println(mySolution(bandage3, maxHealth3, attacks3));  // Expected: -1

        int[] bandage4 = {1, 1, 1};
        int maxHealth4 = 5;
        int[][] attacks4 = {{1, 2}, {3, 2}};
        System.out.println(mySolution(bandage4, maxHealth4, attacks4));  // Expected: 3
    }
}
