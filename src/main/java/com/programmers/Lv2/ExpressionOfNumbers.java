package com.programmers.Lv2;

public class ExpressionOfNumbers {
    public int mySolution(int n) {
        int answer = 0;

        for (int start = 1; start <= n; start++) {
            int sum = 0;

            for (int end = start; end <= n; end++) {
                sum += end;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return answer;
    }

    public int otherSolution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ExpressionOfNumbers expression = new ExpressionOfNumbers();

        int n = 15; // 예시로 15를 사용

        System.out.println("Number of ways to express " + n + " as the sum of consecutive numbers: " + expression.mySolution(n));
        System.out.println("Number of ways to express " + n + " as the sum of consecutive numbers: " + expression.otherSolution(n));
    }
}
