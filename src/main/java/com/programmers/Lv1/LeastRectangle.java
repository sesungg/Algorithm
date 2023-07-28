package com.programmers.Lv1;

public class LeastRectangle {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for(int[] size : sizes) {
            if(size[0] > size[1]) {
                if(size[0] > x) x = size[0];
                if(size[1] > y) y = size[1];
            } else {
                if(size[0] > y) y = size[0];
                if(size[1] > x) x = size[1];
            }
        }

        return x * y;
    }

    public int gptSolution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }

    public static void main(String[] args) {
        LeastRectangle leastRectangle = new LeastRectangle();

        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(leastRectangle.solution(sizes1)); // Output: 4000
        System.out.println(leastRectangle.gptSolution(sizes1)); // Output: 4000

        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(leastRectangle.solution(sizes2)); // Output: 120
        System.out.println(leastRectangle.gptSolution(sizes2)); // Output: 120

        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(leastRectangle.solution(sizes3)); // Output: 133
        System.out.println(leastRectangle.gptSolution(sizes3)); // Output: 133
    }

}
