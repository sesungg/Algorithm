package com.programmers.Lv1;

import java.util.Stack;

public class HamburgerPacking {
    public int mySolution(int[] ingredient) {
        int hamburgers = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i : ingredient) {
            stack.push(i);

            int size = stack.size();
            if(size >= 4) {
                if(stack.get(size - 4) == 1
                    && stack.get(size - 3) == 2
                    && stack.get(size - 2) == 3
                    && i == 1) {
                    hamburgers++;
                    for(int j = 0; j < 4; j++) {
                        stack.pop();
                    }
                }
            }
        }

        return hamburgers;
    }

    public int othersSolution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        HamburgerPacking packing = new HamburgerPacking();

        int[] example1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] example2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        System.out.println(packing.mySolution(example1)); // Output: 2
        System.out.println(packing.mySolution(example2)); // Output: 0
    }
}
