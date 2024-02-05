package com.programmers.Lv2;

public class TournamentTree {
    public int mySolution(int n, int a, int b) {
        int answer = 0;
        a--;
        b--;

        while(a != b) {
            a /= 2;
            b /= 2;
            answer++;
        }


        return answer;
    }

    public int gptSolution(int N, int A, int B) {
        int round = 0;

        while (A != B) {
            A = A / 2 + A % 2; // 다음 라운드에서의 A번 참가자 번호
            B = B / 2 + B % 2; // 다음 라운드에서의 B번 참가자 번호
            round++; // 라운드를 1 증가
        }

        return round;
    }

    public static void main(String[] args) {
        TournamentTree tournament = new TournamentTree();
        int N = 8; // 참가자 수
        int A = 4; // A번 참가자
        int B = 7; // B번 참가자

        System.out.println(tournament.mySolution(N, A, B)); // 결과 출력
    }
}
