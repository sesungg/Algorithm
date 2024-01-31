package com.programmers.Lv2;

public class JumpAndTeleport {
    public int mySolution(int n) {
        int batteryUsage = 0;

        while (n > 0) {
            if (n % 2 != 1) {
                n -= 1;
                batteryUsage++;
            } else {
                n /= 2;
            }
        }

        return batteryUsage;
    }

    public static void main(String[] args) {
        JumpAndTeleport jumpAndTeleport = new JumpAndTeleport();

        System.out.println(jumpAndTeleport.mySolution(5));   // 2
        System.out.println(jumpAndTeleport.mySolution(6));   // 2
        System.out.println(jumpAndTeleport.mySolution(5000)); // 5
    }
}
