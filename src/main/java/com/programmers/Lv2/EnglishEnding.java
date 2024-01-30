package com.programmers.Lv2;

import java.util.Arrays;

public class EnglishEnding {
    public int[] mySolution(int n, String[] words) {
        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String word = words[i];

            if (prevWord.charAt(prevWord.length() - 1) != word.charAt(0)) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }

            for (int j = 0; j < i; j++) {
                if (word.equals(words[j])) {
                    return new int[] {(i % n) + 1, (i / n) + 1};
                }
            }
        }

        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        EnglishEnding englishEnding = new EnglishEnding();
        String[] ex1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(englishEnding.mySolution(3, ex1)));

        String[] ex2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(Arrays.toString(englishEnding.mySolution(5, ex2)));

        String[] ex3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(englishEnding.mySolution(2, ex3)));
    }
}
