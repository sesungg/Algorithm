package com.programmers.Lv2;

public class GameOfNBase {
    public String mySolution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        for (int i = 0; i < t; i++) {
            answer.append(Character.toUpperCase(sb.charAt(p - 1 + i * m)));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        GameOfNBase gameOfNBase = new GameOfNBase();

        System.out.println(gameOfNBase.mySolution(2, 4, 2, 1)); // "0111"
        System.out.println(gameOfNBase.mySolution(16, 16, 2, 1)); // "02468ACE11111111"
        System.out.println(gameOfNBase.mySolution(16, 16, 2, 2)); // "13579BDF01234567"
    }
}
