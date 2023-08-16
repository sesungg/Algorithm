package com.programmers.Lv1;

public class PaintOver {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int roller = section[0];

        for(int i = 1; i < section.length; i++) {
            if(roller + (m - 1) < section[i]) {
                answer++;
                roller = section[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PaintOver paintOver = new PaintOver();

        System.out.println(paintOver.solution(8, 4, new int[]{2, 3, 6})); // Output: [2]
    }
}
