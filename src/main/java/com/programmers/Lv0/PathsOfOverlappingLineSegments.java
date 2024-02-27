package com.programmers.Lv0;

import java.util.HashMap;

public class PathsOfOverlappingLineSegments {
    public int solution(int[][] lines) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                answer++;
            }
        }
        return answer;
    }
}
