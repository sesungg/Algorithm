package com.programmers.Lv1;

import java.util.HashMap;

public class SweatSuit {
    public int mySolution1(int n, int[] lost, int[] reserve) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n + 2; i++) {
            hm.put(i, 1);
            for(int tem : reserve) {
                if(i == tem) {
                    hm.put(i, 2);
                    break;
                }
            }
            for(int los : lost) {
                if(i == los) {
                    hm.put(i, hm.getOrDefault(i, 0) - 1);
                    break;
                }
            }
        }
        for(int i = 1; i < hm.size(); i++) {
            if(hm.get(i) == 2 && hm.get(i - 1) == 0) {
                hm.put(i, 1);
                hm.put(i - 1, 1);
            } else if(hm.get(i) == 2 && hm.get(i + 1) == 0) {
                hm.put(i, 1);
                hm.put(i + 1, 1);
            }
        }
        for(int i = 1; i < hm.size() - 1; i++) {
            if(hm.get(i) >= 1) {
                result += 1;
            }
        }
        return result;
    }

    public int mySolution2(int n, int[] lost, int[] reserve) {
        int result = 0;
        int[] student = new int[n + 2];

        for(int l : lost) {
            student[l]--;
        }
        for(int r : reserve) {
            student[r]++;
        }

        for(int i = 1; i < n + 1; i++) {
            if(student[i] == -1) {
                if(student[i - 1] == 1) {
                    student[i]++;
                    student[i - 1]--;
                    result++;
                } else if(student[i + 1] == 1) {
                    student[i]++;
                    student[i + 1]--;
                    result++;
                }
            } else {
                result++;
            }
        }

        return result;
    }
}
