package com.programmers.Lv2;

public class NextBigNumber {
    public int mySolution (int n) {
        int answer;

        int condition = Integer.bitCount(n);

        while (true) {
            n++;

            if (Integer.bitCount(n) == condition) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        NextBigNumber nextBigNumber = new NextBigNumber();

        System.out.println(nextBigNumber.mySolution(78));
    }
}
