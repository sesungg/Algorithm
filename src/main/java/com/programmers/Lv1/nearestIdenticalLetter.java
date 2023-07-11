package com.programmers.Lv1;

public class nearestIdenticalLetter {
    static class Solution{
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            answer[0] = -1;
            char[] array = s.toCharArray();

            for(int i = 1; i < s.length(); i++) {
                char a = array[i];
                for(int j = i - 1; j >= 0; j--) {
                    if(a == array[j]) {
                        answer[i] = i - j;
                        break;
                    }
                    if(j == 0) {
                        answer[i] = -1;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] banana = solution.solution("banana");
        int[] answer = {-1, -1, -1, 2, 2, 2};
        boolean result = true;

        for (int i = 0; i < banana.length; i++) {
            if (banana[i] != answer[i]) {
                result = false;
            }
        }

        System.out.println("가장 가까운 같은 글자");
        System.out.println(result ? "성공" : "실패");
    }
}
