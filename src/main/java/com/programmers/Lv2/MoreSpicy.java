package com.programmers.Lv2;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.add(s);
        }

        while(queue.size() >= 2 && queue.peek() < K) {
            int a = queue.poll();
            int b = queue.poll();

            queue.add(a + (b * 2));

            answer++;
        }

        if (queue.peek() < K) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        MoreSpicy moreSpicy = new MoreSpicy();
        System.out.println(moreSpicy.solution(new int[]{1, 2, 3, 4, 10, 12}, 7));
        System.out.println(moreSpicy.solution(new int[]{0, 0, 0, 0, 0, 0}, 2));
    }
}
