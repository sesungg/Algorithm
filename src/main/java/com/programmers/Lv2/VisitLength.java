package com.programmers.Lv2;

import java.util.HashMap;

public class VisitLength {
    public int mySolution(String dirs) {
        HashMap<String, Integer> map = new HashMap<>();
        int x = 5;
        int y = 5;
        StringBuilder prev = new StringBuilder();
        StringBuilder next = new StringBuilder();

        for (int i = 0; i < dirs.length(); i++) {
            char move = dirs.charAt(i);
            if (move == 'U' && y != 10) {
                prev.append(x).append(y);
                next.append(x).append(++y);
            } else if (move == 'D' && y != 0) {
                prev.append(x).append(y);
                next.append(x).append(--y);
            } else if (move == 'R' && x != 10) {
                prev.append(x).append(y);
                next.append(++x).append(y);
            } else if (move == 'L' && x != 0) {
                prev.append(x).append(y);
                next.append(--x).append(y);
            }

            if (prev.length() != 0) {
                map.put(prev + next.toString(), map.getOrDefault(prev + next.toString(), 0) + 1);
                map.put(next + prev.toString(), map.getOrDefault(next + prev.toString(), 0) + 1);
                prev.setLength(0);
                next.setLength(0);
            }
        }

        return map.size() / 2;
    }

    public static void main(String[] args) {
        VisitLength visitLength = new VisitLength();

        System.out.println(visitLength.mySolution("ULURRDLLU"));    // 7
        System.out.println(visitLength.mySolution("LULLLLLLU"));    // 7
        System.out.println(visitLength.mySolution("RRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUULU"));    // 11
        System.out.println(visitLength.mySolution("LURDLURDLURDLURDRULD"));    // 7
        System.out.println(visitLength.mySolution("UUUUDUDUDUUU"));    // 5
        System.out.println(visitLength.mySolution("LLLLRLRLRLL"));    // 5
        System.out.println(visitLength.mySolution("LRLRLRLRLRLRLR"));    // 1
    }
}
