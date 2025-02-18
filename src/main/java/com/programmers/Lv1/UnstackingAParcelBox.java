package com.programmers.Lv1;

import java.util.ArrayList;
import java.util.List;

public class UnstackingAParcelBox {
    public int mySolution(int n, int w, int num) {
        int answer = 0;

        while(num <= n) {
            num += 2 * (w - ((num - 1) % w) - 1) + 1;
            answer++;
        }

        return answer;
    }

    public int otherSolution(int n, int w, int num) {
        // 몇 번째 층에 위치하는지
        int layer = (num - 1) / w;

        // 몇 번째 열(column)에 위치하는지 찾기
        int indexInLayer = (num - 1) % w; // 0-based index

        // 열(column) 찾기 (층이 짝수면 왼 -> 오, 홀수면 오 -> 왼)
        int column;
        if (layer % 2 == 0) {
            column = indexInLayer; // 짝수 층: 왼 -> 오
        } else {
            column = w - 1 - indexInLayer; // 홀수 층: 오 -> 왼
        }

        // 위에 있는 상자 개수 계산
        int count = 0;
        for (int i = layer; i < (n + w - 1) / w; i++) {
            if (i % 2 == 0) { // 짝수층: 왼 -> 오
                if (column < (n - i * w)) count++;
            } else { // 홀수층: 오 -> 왼
                if ((w - 1 - column) < (n - i * w)) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        UnstackingAParcelBox solution = new UnstackingAParcelBox();

        System.out.println(solution.mySolution(22, 6, 8));
        System.out.println(solution.otherSolution(22, 6, 8));
    }
}
