package com.programmers.Lv2;

import java.util.*;

public class ChoosingTangerines {
    public int mySolution(int k, int[] tangerine) {
        int answer = 0;

        if (k == 1) return 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        int typeCount = 0;
        int[] tangerineCount = new int[map.size()];

        for (Integer key : map.keySet()) {
            tangerineCount[typeCount++] = map.get(key);
        }

        Arrays.sort(tangerineCount);

        while(k > 0) {
            if (k < tangerineCount[typeCount - 1]) {
                answer++;
                break;
            } else {
                k -= tangerineCount[--typeCount];
                answer++;
            }
        }


        return answer;
    }

    public int gptSolution(int k, int[] tangerine) {
        // 귤의 크기별로 빈도수를 계산합니다.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int size : tangerine) {
            frequencyMap.put(size, frequencyMap.getOrDefault(size, 0) + 1);
        }

        // 빈도수를 기준으로 우선순위 큐(최소 힙)에 저장합니다.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer i : frequencyMap.keySet()) {
            minHeap.add(frequencyMap.get(i));
        }

        int types = 0; // 선택한 귤의 크기 종류 수

        while(k > 0) {
            if (minHeap.peek() > k) {
                types++;
                break;
            } else {
                k -= minHeap.poll();
                types++;
            }
        }

        return types;
    }

    public static void main(String[] args) {
        ChoosingTangerines choosingTangerines = new ChoosingTangerines();
        System.out.println(choosingTangerines.mySolution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 3
        System.out.println(choosingTangerines.mySolution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 2
        System.out.println(choosingTangerines.mySolution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})); // 1

        System.out.println(choosingTangerines.gptSolution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 3
        System.out.println(choosingTangerines.gptSolution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 2
        System.out.println(choosingTangerines.gptSolution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})); // 1
    }
}
