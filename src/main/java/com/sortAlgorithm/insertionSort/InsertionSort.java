package com.sortAlgorithm.insertionSort;

import com.utils.TimeUtil;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // 정렬된 부분에서 key보다 큰 요소들을 한 칸씩 뒤로 이동시킨다.
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1, 3};
        TimeUtil timeUtil = new TimeUtil();
        timeUtil.start();
        insertionSort(array);
        timeUtil.printElapsedTimeInSeconds();
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
