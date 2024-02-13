package com.programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class Promotion {
    public int mySolution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < discount.length - 9; i++) {
            int sum = 0;

            for (int j = i; j < i + 10; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }

            for (int j = 0; j < want.length; j++) {
                if (map.get(want[j]) == null) {
                    break;
                } else if (map.get(want[j]) != number[j]) {
                    break;
                } else {
                    sum++;
                }
            }

            if (sum == want.length) {
                answer++;
            }

            map.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        Promotion promotion = new Promotion();

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(promotion.mySolution(want, number, discount));
    }
}
