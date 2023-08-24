package com.programmers.Lv2;

import java.util.Arrays;

public class CreateMinimum {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++) {
            answer += (A[i] * B[B.length - 1 - i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        CreateMinimum minimum = new CreateMinimum();

        int[] A1 = {1, 4, 2};
        int[] B1 = {5, 4, 4};
        System.out.println(minimum.solution(A1, B1)); // Output: 29

        int[] A2 = {1, 2};
        int[] B2 = {3, 4};
        System.out.println(minimum.solution(A2, B2)); // Output: 10
    }
}
