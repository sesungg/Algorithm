package com.programmers.Lv1;

public class CokeProblem {
    public int solution(int a, int b, int currentCnt) {
        int answer = 0;

        while(currentCnt >= a) {
            int returnCnt = (currentCnt / a) * b;
            int payCnt = currentCnt - (currentCnt % a);

            answer += returnCnt;

            currentCnt = (currentCnt - payCnt) + returnCnt;
        }

        return answer;
    }

    public int otherSolution(int a, int b, int n) {
        return (n > b ? n - b : 0) / (a - b) * b;
    }

    public int gptSolution(int a, int b, int n) {
        int totalBottles = 0;
        int emptyBottles = n;

        while (emptyBottles >= a) {
            int newBottles = emptyBottles / a * b;
            totalBottles += newBottles;
            emptyBottles = emptyBottles % a + newBottles;
        }

        return totalBottles;
    }
}
