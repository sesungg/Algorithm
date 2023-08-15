package com.programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CellPhoneKeyboard {
    public int[] mySolution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Arrays.fill(answer, 0);

        List<HashMap<Character, Integer>> list = new ArrayList<>();

        for(int i = 0; i < keymap.length; i++) {

            String key = keymap[i];
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = key.length() - 1; j >= 0; j--) {
                map.put(key.charAt(j), j + 1);
            }

            list.add(map);
        }

        for(int i = 0; i < targets.length; i++) {
            String target = targets[i];

            for(int j = 0; j < target.length(); j++) {
                char t = target.charAt(j);
                int min = 10001;

                for(int n = 0; n < list.size(); n++) {
                    if(list.get(n).get(t) == null) {
                        continue;
                    } else if(min > list.get(n).get(t)) {
                        min = list.get(n).get(t);
                    }
                }
                answer[i] += min;
            }

            if(answer[i] >= 10001) {
                answer[i] = -1;
            }
        }
        return answer;
    }

    public int[] othersSolution(String[] keymap, String[] targets) {
        int[] minTouch = new int['Z' - 'A' + 1];
        Arrays.fill(minTouch, 200);
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                minTouch[key.charAt(i) - 'A'] = Math.min(minTouch[key.charAt(i) - 'A'], i + 1);
            }
        }
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            boolean canMake = true;
            for (int j = 0; j < target.length(); j++) {
                if (minTouch[target.charAt(j) - 'A'] == 200) {
                    canMake = false;
                    break;
                }
                sum += minTouch[target.charAt(j) - 'A'];
            }
            answer[i] = canMake ? sum : -1;
        }
        return answer;
    }
    public static void main(String[] args) {
        CellPhoneKeyboard cellPhoneKeyboard = new CellPhoneKeyboard();

        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] targets1 = {"ABCD", "AABB"};
        System.out.println(Arrays.toString(cellPhoneKeyboard.mySolution(keymap1, targets1))); // Output: [9, 4]

        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};
        System.out.println(Arrays.toString(cellPhoneKeyboard.mySolution(keymap2, targets2))); // Output: [-1]

        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA", "BGZ"};
        System.out.println(Arrays.toString(cellPhoneKeyboard.mySolution(keymap3, targets3))); // Output: [4, 6]

        String[] keymap4 = {"BC"};
        String[] targets4 = {"AC", "BC"};
        System.out.println(Arrays.toString(cellPhoneKeyboard.mySolution(keymap4, targets4))); // Output: [-1, 3]

        String[] keymap5 = {"BC", "CDB"};
        String[] targets5 = {"BB"};
        System.out.println(Arrays.toString(cellPhoneKeyboard.mySolution(keymap5, targets5))); // Output: [2]
    }
}
