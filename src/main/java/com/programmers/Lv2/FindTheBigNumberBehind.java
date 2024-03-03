package com.programmers.Lv2;

import java.util.Arrays;
import java.util.Stack;

public class FindTheBigNumberBehind {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        FindTheBigNumberBehind solution = new FindTheBigNumberBehind();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] result = solution.solution(numbers);
        System.out.println(Arrays.toString(result)); // 예상 결과: [-1, 5, 6, 6, -1, -1]
    }
}
