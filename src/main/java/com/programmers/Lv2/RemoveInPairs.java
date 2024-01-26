package com.programmers.Lv2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveInPairs {
    public int mySolution(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        deque.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (deque.peek() == null) {
                deque.push(s.charAt(i));
                continue;
            }

            if (deque.getFirst().equals(s.charAt(i))) {
                deque.pop();
            } else {
                deque.push(s.charAt(i));
            }
        }

        return deque.isEmpty() ? 1 : 0;
    }

    public int otherSolution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        RemoveInPairs removeInPairs = new RemoveInPairs();

        System.out.println(removeInPairs.mySolution("baabaa"));
    }

}
