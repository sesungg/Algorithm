package com.sortAlgorithm.bubbleSort;

import com.utils.TimeUtil;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 인접한 요소를 비교하고 교환한다.
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // 만약 더 이상 교환이 이루어지지 않았다면, 정렬이 완료된 것이다.
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2, 8};
        TimeUtil timeUtil = new TimeUtil();
        timeUtil.start();
        bubbleSort(array);
        timeUtil.getElapsedTimeInSeconds();
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
