package com.programmers.Lv0;

public class RemoveSpecificChar {
    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter, "");
    }
}
