package com.programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    public int mySolution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        for (String s : map.keySet()) {
            answer *= map.get(s) + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Clothes clothes = new Clothes();

        System.out.println(clothes.mySolution(new String[][] {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));    // 5
        System.out.println(clothes.mySolution(new String[][] {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        }));    // 3
    }
}
