package com.programmers.Lv2;

import java.util.HashMap;

public class VowelDictionary {
    public int mySolution(String word) {
        int answer = 0;
        char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
        int[] cha = {781, 156, 31, 6, 1};
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < alphabet.length; i++) {
            map.put(alphabet[i], i);
        }

        answer += word.length();

        for (int i = 0; i < word.length(); i++) {
            answer += cha[i] * alphabet[word.charAt(i)];
        }

        return answer;
    }
}
