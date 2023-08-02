package com.programmers.Lv1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CraneCatchGame {

    public int mySolution(int[][] board, int[] moves) {
        int answer = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                int toy = board[j][moves[i] - 1];

                if(toy != 0) {
                    if(!stack.isEmpty() && stack.peek() == toy) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(toy);
                    }

                    board[j][moves[i] - 1] = 0;
                    break;
                }

            }
        }

        return answer;
    }

    public int gptSolution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer>[] stacks = new Stack[n];

        // Initialize stacks with dolls from the board
        for (int i = 0; i < n; i++) {
            stacks[i] = new Stack<>();
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    stacks[i].push(board[j][i]);
                }
            }
        }

        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            int column = move - 1;
            if (!stacks[column].isEmpty()) {
                int doll = stacks[column].pop();
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CraneCatchGame myGame = new CraneCatchGame();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int myResult = myGame.mySolution(board, moves);
        System.out.println(myResult); // Output: 4
    }
}
