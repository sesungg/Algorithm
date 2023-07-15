package com.programmers.Lv1;

public class ParkWalk {
    static class Solution {
        public int[] mySolution(String[] park, String[] routes) {
            int[] answer = new int[2];
            String[][] parkMap = new String[park.length][park[0].length()];
            int x = 0;
            int y = 0;

            for(int i = 0; i < park.length; i++) {
                // 공원 지도 생성
                parkMap[i] = park[i].split("");
                // 강쥐의 현 위치 찾은 후 저장
                if(park[i].indexOf("S") > -1) {
                    x = i;
                    y = park[i].indexOf("S");
                }
            }

            for(int i = 0; i < routes.length; i++) {
                boolean flag = true;
                String route = routes[i];

                // 방향
                char op = route.charAt(0);
                // 거리
                int n = Integer.parseInt(route.substring(2));


                // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인
                try {
                    if (op == 'E') {
                        // 주어진 방향으로 이동할 때 장애물을 만나는지 확인
                        for(int j = y + 1; j <= y + n; j++) {
                            if (parkMap[x][j].equals("X")) {
                                flag = false;
                                break;
                            }
                        }
                        // 공원을 벗어나지도, 장애물을 만나지도 않는다면 이동
                        if (flag) {
                            parkMap[x][y] = "O";
                            parkMap[x][y + n] = "S";
                            y = y + n;
                        }

                    } else if (op == 'W') {
                        for(int j = y; j >= y - n; j--) {
                            if (parkMap[x][j].equals("X")) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            parkMap[x][y] = "O";
                            parkMap[x][y - n] = "S";
                            y = y - n;
                        }
                    } else if (op == 'S') {
                        for(int j = x + 1; j <= x + n; j++) {
                            if (parkMap[j][y].equals("X")) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            parkMap[x][y] = "O";
                            parkMap[x + n][y] = "S";
                            x = x + n;
                        }
                    } else if (op == 'N') {
                        for(int j = x; j >= x - n; j--) {
                            if (parkMap[j][y].equals("X")) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            parkMap[x][y] = "O";
                            parkMap[x - n][y] = "S";
                            x = x - n;
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }
            }

            answer[0] = x;
            answer[1] = y;

            return answer;
        }
    }
}
