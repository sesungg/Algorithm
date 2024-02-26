package com.programmers.Lv2;

import java.util.*;

public class Compression {
    public int[] solution(String msg) {
        // 사전을 초기화한다. 영문 대문자에 해당하는 ASCII 코드 값은 65(A)에서 90(Z)이다.
        int dictSize = 26;
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 1; i <= dictSize; i++) {
            dict.put(String.valueOf((char) (i + 64)), i);
        }

        List<Integer> result = new ArrayList<>();

        StringBuilder w = new StringBuilder("");

        for (char c : msg.toCharArray()) {
            StringBuilder wc = new StringBuilder();
            wc.append(w);
            wc.append(c);

            if (dict.containsKey(wc.toString())) {
                w = wc;
            } else {
                result.add(dict.get(w.toString()));

                dict.put(wc.toString(), ++dictSize);

                w = new StringBuilder(String.valueOf(c));
            }
        }

        if (!w.equals("")) {
            result.add(dict.get(w.toString()));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Compression compression = new Compression();
        System.out.println("KAKAO : " + Arrays.toString(compression.solution("KAKAO")));
        System.out.println("TOBEORNOTTOBEORTOBEORNOT : " + Arrays.toString(compression.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println("ABABABABABABABAB : " + Arrays.toString(compression.solution("ABABABABABABABAB")));
    }
}
