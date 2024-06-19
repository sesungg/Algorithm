package com.sortAlgorithm.MergeSort;

import com.utils.TimeUtil;

public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // 좌측 반 배열 생성 및 재귀적으로 정렬
            int[] left = new int[mid];
            System.arraycopy(array, 0, left, 0, mid);
            mergeSort(left);

            // 우측 반 배열 생성 및 재귀적으로 정렬
            int[] right = new int[array.length - mid];
            System.arraycopy(array, mid, right, 0, array.length - mid);
            mergeSort(right);

            // 정렬된 좌측 반과 우측 반을 병합
            merge(array, left, right);
        }
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 좌측과 우측 반 배열을 비교하면서 병합
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // 좌측 반 배열의 남은 요소들을 결과 배열에 추가
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // 우측 반 배열의 남은 요소들을 결과 배열에 추가
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 92, 10};
        TimeUtil timeUtil = new TimeUtil();
        timeUtil.start();
        mergeSort(array);
        timeUtil.printElapsedTimeInSeconds();
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
