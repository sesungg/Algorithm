package com.programmers.Lv0;

public class SpiralMatrixGenerator {
    static class Solution{
        public int[][] solution(int n) {
            int[][] answer = new int[n][n];
            int top = 0;
            int right = n - 1;
            int left = 0;
            int bottom = n - 1;
            int num = 0;

            for(int i = 0; i < n * n - 1; i++) {
                int axis = i % 4;

                if(axis == 0) {
                    for(int j = left; j <= right; j++) {
                        answer[top][j] = num++;
                    }
                    top++;
                } else if (axis == 1) {
                    for(int j = top; j <= bottom; j++) {
                        answer[j][right] = num++;
                    }
                    right--;
                } else if (axis == 2) {
                    for(int j = right; j >= left; j--) {
                        answer[bottom][j] = num++;
                    }
                    bottom--;
                } else {
                    for(int j = bottom; j >= top; j--) {
                        answer[j][left] = num++;
                    }
                    left++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(4);
    }
}
