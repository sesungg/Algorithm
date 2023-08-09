package com.programmers.Lv1;

import java.util.HashMap;

public class PersonalityTest {
    public String solution(String[] survey, int[] choices) {
        StringBuffer sb = new StringBuffer();

        char[][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        HashMap<Character, Integer> map = new HashMap();

        for(char[] t : type) {
            map.put(t[0], 0);
            map.put(t[1], 0);
        }

        for(int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);

            // 선택지 번호 - 4 = |점수|
            if(choices[i] > 4) {
                map.put(b, map.get(b) + Math.abs(choices[i] - 4));
            } else {
                map.put(a, map.get(a) + Math.abs(choices[i] - 4));
            }
        }

        for(char[] t : type) {
            sb.append(map.get(t[0]) >= map.get(t[1]) ? t[0] : t[1]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(new PersonalityTest().solution(survey, choices)); // Output will be "RFCN"
    }
}
