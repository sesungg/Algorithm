package com.sortAlgorithm.quickSort;

public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);  // 피벗 기준 왼쪽 부분 정렬
            quickSort(array, pi + 1, high); // 피벗 기준 오른쪽 부분 정렬
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // 작은 요소의 인덱스

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // array[i]와 array[j]를 교환
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // array[i+1]와 array[high] (또는 피벗)을 교환
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 8, 10, 1, 2, 1};
        int n = array.length;

        quickSort(array, 0, n - 1);

        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
