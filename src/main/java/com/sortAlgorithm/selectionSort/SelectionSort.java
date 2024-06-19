package com.sortAlgorithm.selectionSort;

import com.utils.TimeUtil;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // i번째 원소부터 끝까지 중 가장 작은 원소의 인덱스를 찾는다.
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // 가장 작은 원소를 i번째 원소와 교환한다.
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        TimeUtil timeUtil = new TimeUtil();
        int[] array = {29, 10, 14, 37, 13};

        timeUtil.start();
        selectionSort(array);
        timeUtil.printElapsedTimeInSeconds();

        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
