package com.programmers.Lv2;

import java.util.Arrays;

public class CuttingPowArray {
    public int[] mySolution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            int x = (int) (left / n + 1);
            int y = (int) (left % n + 1);

            answer[i] = Math.max(x, y);
            left++;
        }

        return answer;
    }

    public static void main(String[] args) {
        CuttingPowArray cuttingPowArray = new CuttingPowArray();
        // [3, 2, 2, 3]
        System.out.println(Arrays.toString(cuttingPowArray.mySolution(3, 2, 5)));
        // [4, 3, 3, 3, 4, 4, 4, 4]
        System.out.println(Arrays.toString(cuttingPowArray.mySolution(4, 7, 14)));
        // [10000000]
        System.out.println(Arrays.toString(cuttingPowArray.mySolution(10000000, 99999999999L, 99999999999L)));
    }
}
