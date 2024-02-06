package com.programmers.Lv2;

class LCM {
    public long mySolution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int a = Math.max(arr[i], arr[i + 1]);
            int b = Math.min(arr[i], arr[i + 1]);
            int remainder = 0;
            while(true) {
                if (a % b != 0) {
                    remainder = a % b;
                    a = b;
                    b = remainder;
                } else {
                    arr[i + 1] = (arr[i] * arr[i + 1]) / b;
                    break;
                }
            }
        }

        return arr[arr.length - 1];
    }

    public int gptSolution(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }

        return result;
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        LCM lcm = new LCM();

        int[] arr1 = {2, 6, 8, 14};
        int[] arr2 = {1, 2, 3};

        System.out.println(lcm.mySolution(arr1)); // 출력: 168
        System.out.println(lcm.mySolution(arr2)); // 출력: 6
    }
}