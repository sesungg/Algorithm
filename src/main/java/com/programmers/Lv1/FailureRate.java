package com.programmers.Lv1;

import java.util.Arrays;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 스테이지에 도달한 플레이어 수
        int players = stages.length;

        int[] stageIndex = new int[N];
        double[] failureRate = new double[N];

        for(int i = 1; i <= N; i++) {

            // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            double fail = 0;

            for(int j = 0; j < stages.length; j++) {
                if(i == stages[j]) {
                    fail++;
                }
            }
            // 스테이지
            stageIndex[i - 1] = i;
            // 실패율
            failureRate[i - 1] = (fail / players) * 100;

            // 스테이지에 도달한 플레이어 수 감소
            players -= fail;
            System.out.println(failureRate[i - 1]);
        }

        for(int i = 0; i < N; i++) {
            int stageTem = stageIndex[i];
            double rateTem = failureRate[i];
            for(int j = i; j < N; j++) {
                if(rateTem < failureRate[j]) {
                    rateTem = failureRate[j];
                    failureRate[j] = failureRate[i];
                    failureRate[i] = rateTem;

                    stageTem = stageIndex[j];
                    stageIndex[j] = stageIndex[i];
                    stageIndex[i] = stageTem;
                } else if(rateTem == failureRate[j]) {
                    if(stageTem > stageIndex[j]) {
                        rateTem = failureRate[j];
                        failureRate[j] = failureRate[i];
                        failureRate[i] = rateTem;

                        stageTem = stageIndex[j];
                        stageIndex[j] = stageIndex[i];
                        stageIndex[i] = stageTem;
                    }
                }
            }
        }



        return stageIndex;
    }

    public static void main(String[] args) {
        FailureRate FailureRate = new FailureRate();
        int[] solution = FailureRate.solution(2, new int[]{1, 1, 1, 1});
        System.out.println("solution = " + Arrays.toString(solution));
    }
}
