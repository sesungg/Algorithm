package com.programmers.Lv1;

public class DesktopCleanup {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = 51;
        int luy = 51;
        int rdx = 1;
        int rdy = 1;

        for(int i = 0; i < wallpaper.length; i++) {
            String x = wallpaper[i];

            // 가로줄에 파일이 있다면
            if(x.indexOf("#") > -1) {
                // 처음 파일의 위치
                if(lux > i) {
                    lux = i;
                }
                // 마지막 파일이 있는 줄
                rdx = i + 1;

                // Y 값보다 작은지 확인
                if(luy > x.indexOf("#")) {
                    luy = x.indexOf("#");
                }

                // 해당 줄에 다음 파일 확인
                String[] xArray = x.split("");
                for(int j = luy + 1; j <= xArray.length; j++) {
                    if(xArray[j - 1].equals("#")) {
                        if(rdy < j) {
                            rdy = j;
                        }
                    }
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;
        return answer;
    }

    public static void main(String[] args) {
        DesktopCleanup desktopCleanup = new DesktopCleanup();

        String[] wallpaper1 = {".#...", "..#..", "...#."};
        int[] result1 = desktopCleanup.solution(wallpaper1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [0, 1, 3, 4]

        String[] wallpaper2 = {"..........", ".....#....", "......##..", "...##. ....", "....#....."};
        int[] result2 = desktopCleanup.solution(wallpaper2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [1, 3, 5, 8]

        String[] wallpaper3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#. ", "..#...#..", "...#.#...", "..#...."};
        int[] result3 = desktopCleanup.solution(wallpaper3);
        System.out.println(java.util.Arrays.toString(result3)); // Output: [0, 0, 7, 9]

        String[] wallpaper4 = {"..", "#."};
        int[] result4 = desktopCleanup.solution(wallpaper4);
        System.out.println(java.util.Arrays.toString(result4)); // Output: [1, 0, 2, 1]
    }
}
