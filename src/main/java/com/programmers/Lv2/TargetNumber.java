package com.programmers.Lv2;

public class TargetNumber {
    public int dfs(int[] numbers, int target, int depth, int sum) {
        int result = 0;

        if (depth == numbers.length) {
            if (target == sum) {
                return 1;
            }

            return 0;
        }

        result += dfs(numbers, target, depth + 1, sum + numbers[depth]);
        result += dfs(numbers, target, depth + 1, sum - numbers[depth]);

        return result;
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }


    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        System.out.println(targetNumber.solution(new int[] {1, 1, 1, 1, 1}, 3));
    }
}
