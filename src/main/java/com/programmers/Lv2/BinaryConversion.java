package com.programmers.Lv2;

import java.util.Arrays;

public class BinaryConversion {
    public int[] mySolution(String s) {
        int[] answer = new int[2];

        int length = s.length();

        while(!s.equals("1")) {
            s = s.replaceAll("0", "");

            answer[0]++;
            answer[1] += length - s.length();

            s = Integer.toBinaryString(s.length());

            length = s.length();
        }
        return answer;
    }

    public int[] gptSolution(String s) {
        int binaryConversions = 0;
        int zerosRemoved = 0;

        while (!s.equals("1")) {
            int c = s.length();
            int zeroCount = 0;

            for (int i = 0; i < c; i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }

            binaryConversions++;
            zerosRemoved += zeroCount;

            c -= zeroCount;
            s = Integer.toBinaryString(c);
        }

        return new int[]{binaryConversions, zerosRemoved};
    }

    public static void main(String[] args) {
        BinaryConversion conversion = new BinaryConversion();

        String[] inputs = {"110010101001", "01110", "1111111"};
        for (String input : inputs) {
            int[] result = conversion.mySolution(input);
            System.out.println(Arrays.toString(result));
        }
    }
}
