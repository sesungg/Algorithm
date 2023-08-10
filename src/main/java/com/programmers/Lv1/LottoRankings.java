package com.programmers.Lv1;

import java.util.Arrays;

public class LottoRankings {
    public int[] mySolution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int same = 0;
        int blind = 0;
        for(int lotto : lottos) {
            if(lotto != 0) {
                for(int nums : win_nums) {
                    if(lotto == nums) {
                        same++;
                        break;
                    }
                }
            } else {
                blind++;
            }
        }

        answer[0] = 7 - (same + blind);
        answer[1] = 7 - same;

        if(answer[0] == 7) {
            answer[0] = 6;
        }
        if(answer[1] == 7) {
            answer[1] = 6;
        }

        return answer;
    }

    public int[] othersSolution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int cnt1 = 0;
        int cnt2 = 0;
        for(int i : lottos) {
            if(i == 0) {
                cnt1++;
                continue;
            }
            for(int j : win_nums) {
                if(i == j) cnt2++;
            }
        }


        answer[0] = getGrade(cnt1+cnt2);
        answer[1] = getGrade(cnt2);

        return answer;
    }

    public int getGrade(int n) {
        switch(n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }

    public int[] gptSolution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correctCount = 0;
        int zeroCount = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
                continue;
            }

            for (int winNum : win_nums) {
                if (num == winNum) {
                    correctCount++;
                    break;
                }
            }
        }

        int highestRank = Math.min(7 - (correctCount + zeroCount), 6);
        int lowestRank = Math.min(7 - correctCount, 6);

        answer[0] = highestRank;
        answer[1] = lowestRank;

        return answer;
    }

    public static void main(String[] args) {
        LottoRankings lottoRankings = new LottoRankings();

        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(lottoRankings.mySolution(lottos1, win_nums1))); // Output: [3, 5]

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        System.out.println(Arrays.toString(lottoRankings.mySolution(lottos2, win_nums2))); // Output: [1, 6]

        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(lottoRankings.mySolution(lottos3, win_nums3))); // Output: [1, 1]
    }
}
