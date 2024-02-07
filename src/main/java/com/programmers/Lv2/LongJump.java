package com.programmers.Lv2;

public class LongJump {
    public int mySolution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int mod = 1234567;
        int[] ways = new int[n+1];
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = (ways[i-1] + ways[i-2]) % mod;
        }

        return ways[n];
    }

    public static void main(String[] args) {
        LongJump sol = new LongJump();
        System.out.println(sol.mySolution(4)); // 출력: 5
        System.out.println(sol.mySolution(3)); // 출력: 3
    }
}
