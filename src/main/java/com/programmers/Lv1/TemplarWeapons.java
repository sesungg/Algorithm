package com.programmers.Lv1;

public class TemplarWeapons {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        // number만큼 반복
        for(int i = 1; i <= number; i++) {
            // 약수의 개수를 구하기
            int divisorCnt = 0;

            for(int j = 1; j <= Math.sqrt(i); j++) {
                if(j * j == i) divisorCnt++;
                else if(i % j == 0) divisorCnt+=2;
            }

            answer += divisorCnt > limit ? power : divisorCnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        TemplarWeapons solution = new TemplarWeapons();

        System.out.println(solution.solution(5, 10, 2));
    }
}
