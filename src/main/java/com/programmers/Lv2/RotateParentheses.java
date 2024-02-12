package com.programmers.Lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class RotateParentheses {
    public int mySolution(String s) {
        int answer = 0;

        char[] charArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < charArr.length; i++) {
            for (int j = i; j < charArr.length + i; j++) {
                int index = j % charArr.length;

                if (stack.peek() == null) {
                    stack.push(charArr[index]);
                    continue;
                }
                if (charArr[index] == '(' || charArr[index] == '{' || charArr[index] == '[') {
                    stack.push(charArr[index]);
                } else {
                    if (stack.peek() == '(' && charArr[index] == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && charArr[index] == '}') {
                        stack.pop();
                    } else if (stack.peek() == '[' && charArr[index] == ']') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            } else {
                stack.clear();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RotateParentheses rotateParentheses = new RotateParentheses();

        System.out.println(rotateParentheses.mySolution("{{(())}}[][]"));   // 3
        System.out.println(rotateParentheses.mySolution("[](){}"));         // 3
        System.out.println(rotateParentheses.mySolution("}]()[{"));         // 2
        System.out.println(rotateParentheses.mySolution("[)(]"));           // 0
        System.out.println(rotateParentheses.mySolution("}}}"));            // 0
    }
}
