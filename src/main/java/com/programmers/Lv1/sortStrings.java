package com.programmers.Lv1;

import java.util.Arrays;
import java.util.Comparator;

public class sortStrings {
    public static String[] sortStrings(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.charAt(n) > s2.charAt(n)) {
                    return 50;
                } else if(s1.charAt(n) < s2.charAt(n)) {
                    return -50;
                } else if(s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }
                return 0;
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        String[] strings1 = {"sun", "bed", "car"};
        int n1 = 1;
        String[] sortedStrings1 = sortStrings(strings1, n1);
        System.out.println(Arrays.toString(sortedStrings1));  // Output: [car, bed, sun]

        String[] strings2 = {"abce", "abcd", "cdx"};
        int n2 = 2;
        String[] sortedStrings2 = sortStrings(strings2, n2);
        System.out.println(Arrays.toString(sortedStrings2));  // Output: [abcd, abce, cdx]
    }
}

