package com.programmers.Lv2;

import java.util.*;

public class FunctionDevelopment {
    private int[] mySolution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int work = (remain / speeds[i]) + (remain % speeds[i] != 0 ? 1 : 0);

            if (deque.isEmpty()) {
                deque.add(work);
            } else if (deque.peek() >= work) {
                deque.add(work);
            } else if (deque.peek() < work) {
                list.add((deque.size()));
                deque.clear();
                deque.add(work);
            }
        }

        list.add(deque.size());

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        FunctionDevelopment functionDevelopment = new FunctionDevelopment();
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(functionDevelopment.mySolution(progresses1, speeds1)));
        System.out.println(Arrays.toString(functionDevelopment.mySolution(progresses2, speeds2)));
    }
}