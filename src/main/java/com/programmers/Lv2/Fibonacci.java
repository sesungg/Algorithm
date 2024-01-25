package com.programmers.Lv2;

public class Fibonacci {
    public int mySolution(int n) {
        int[] array = new int[n + 1];

        array[0] = 0;
        array[1] = 1;

        int modNum = 1234567;

        for (int i = 2; i <= n; i++) {
            array[i] = ((array[i - 1] % modNum) + (array[i - 2] % modNum) % modNum);
        }

        return array[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.mySolution(5));
    }
}
