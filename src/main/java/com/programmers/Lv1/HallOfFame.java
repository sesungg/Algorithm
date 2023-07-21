package com.programmers.Lv1;

import java.util.PriorityQueue;

public class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i = 0; i < score.length; i++) {
            pq.offer(score[i]);

            if(pq.size() > k) {
                pq.poll();
            }

            answer[i] = pq.peek();

        }

        return answer;
    }
}
