package com.programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Process {
    public int mySolution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> orderQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
            orderQueue.offer(i);
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            int order = orderQueue.poll();

            boolean flag = false;

            for (Integer q : queue) {
                if (n < q) flag = true;
                if (flag) break;
            }

            if (flag) {
                queue.offer(n);
                orderQueue.offer(order);
            } else if (order == location) {
                break;
            }
        }
        return priorities.length - queue.size();
    }

    public static void main(String[] args) {
        Process process = new Process();
        System.out.println(process.mySolution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(process.mySolution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
        System.out.println(process.mySolution(new int[]{1, 2, 3, 4, 5}, 2)); // 3
    }
}
