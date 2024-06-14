package com.utils;

import java.text.DecimalFormat;

public class TimeUtil {
    private long startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public String getElapsedTimeInSeconds() {
        long endTime = System.nanoTime();
        // 나노초를 초 단위로 변환.
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        // 소수점 다섯 번째 자리까지 반올림하여 반환.
        DecimalFormat df = new DecimalFormat("0.00000");
        return df.format(elapsedTimeInSeconds);
    }
}
