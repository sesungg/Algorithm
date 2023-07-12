package com.programmers.Lv0;

public class CountingOfK {
    static class Solution {
        public int solution(int startNum, int endNum, int checkNum){
            int answer = 0;
            int current = 0;
            int digit = 0;

            for (int i = startNum; i <= endNum; i++) {
                current = i;

                while (current > 0) {
                    digit = current % 10;
                    if (digit == checkNum) {
                        answer++;
                    }
                    current /= 10;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int firstResult = solution.solution(1, 13, 1);
        System.out.println("startNumber : 1");
        System.out.println("endNumber : 13");
        System.out.println("checkNumber : 1");

        if (firstResult == 6) {
            System.out.println("success");
        }
    }
}
