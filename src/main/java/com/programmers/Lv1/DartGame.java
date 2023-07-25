package com.programmers.Lv1;

public class DartGame {
    public static int mySolution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];

        String[] result = dartResult.split("");

        int index = 0;

        for (int i = 0; i < result.length; i++) {
            score[index] = Integer.parseInt(result[i]);

            char tem = result[i + 1].charAt(0);

            if (tem == 48) {
                score[index] = 10;
                i++;
            }

            switch (result[i + 1]) {
                case "D":
                    score[index] = score[index] * score[index];
                    break;
                case "T":
                    score[index] = score[index] * score[index] * score[index];
                    break;
            }

            if (result.length != i + 2) {
                if (result[i + 2].equals("*")) {
                    if (index == 0) {
                        score[index] = score[index] * 2;
                    } else {
                        score[index - 1] = score[index - 1] * 2;
                        score[index] = score[index] * 2;
                    }
                    i += 2;
                } else if (result[i + 2].equals("#")) {
                    score[index] *= -1;
                    i += 2;
                } else {
                    i++;
                }
            } else {
                break;
            }

            index++;

        }


        return score[0] + score[1] + score[2];
    }

    public int gptSolution(String dartResult) {
        int[] scores = new int[3];
        int currentChance = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if (Character.isDigit(ch)) {
                currentChance++;
                if (ch == '1' && dartResult.charAt(i + 1) == '0') {
                    scores[currentChance] = 10;
                    i++; // Skip the next character '0'
                } else {
                    scores[currentChance] = ch - '0';
                }
            } else {
                int bonusScore = calculateBonusScore(ch, scores[currentChance]);
                scores[currentChance] = bonusScore;
                if (i + 1 < dartResult.length()) {
                    char nextCh = dartResult.charAt(i + 1);
                    if (nextCh == '*' || nextCh == '#') {
                        calculateOptionScore(nextCh, scores, currentChance);
                        i++; // Skip the next character '*' or '#'
                    }
                }
            }
        }

        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }

    private static int calculateBonusScore(char bonus, int score) {
        int bonusScore;
        switch (bonus) {
            case 'S':
                bonusScore = score;
                break;
            case 'D':
                bonusScore = score * score;
                break;
            case 'T':
                bonusScore = score * score * score;
                break;
            default:
                bonusScore = 0;
        }
        return bonusScore;
    }

    private static void calculateOptionScore(char option, int[] scores, int currentChance) {
        switch (option) {
            case '*':
                if (currentChance > 0) {
                    scores[currentChance - 1] *= 2;
                }
                scores[currentChance] *= 2;
                break;
            case '#':
                scores[currentChance] *= -1;
                break;
        }
    }

    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        int result = DartGame.mySolution(dartResult);
        System.out.println(result);  // Output: 37
    }
}
