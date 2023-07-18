package com.programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

public class NumberWordDecoder {
    static class Solution{
        public int mySolution(String s) {
            String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for(int i = 0; i < 10; i++) {
                s = s.replace(number[i], String.valueOf(i + 1));
            }

            return Integer.parseInt(s);
        }

        public int gptSolution(String s) {
            Map<String, Integer> wordToNumber = initializeWordToNumberMap();
            StringBuilder numberBuilder = new StringBuilder();
            StringBuilder currentWord = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (47 < ch && 58 > ch) {
                    numberBuilder.append(ch);
                    continue;
                }
                currentWord.append(ch);

                if (wordToNumber.containsKey(currentWord.toString())) {
                    numberBuilder.append(wordToNumber.get(currentWord.toString()));
                    currentWord.setLength(0);
                }
            }

            return Integer.parseInt(numberBuilder.toString());
        }

        private Map<String, Integer> initializeWordToNumberMap() {
            Map<String, Integer> wordToNumber = new HashMap<>();
            wordToNumber.put("zero", 0);
            wordToNumber.put("one", 1);
            wordToNumber.put("two", 2);
            wordToNumber.put("three", 3);
            wordToNumber.put("four", 4);
            wordToNumber.put("five", 5);
            wordToNumber.put("six", 6);
            wordToNumber.put("seven", 7);
            wordToNumber.put("eight", 8);
            wordToNumber.put("nine", 9);
            return wordToNumber;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.mySolution("one4seveneight");
            System.out.println(solution.gptSolution("one4seveneight"));
        }
    }
}
