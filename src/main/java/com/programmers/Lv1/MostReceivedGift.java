package com.programmers.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostReceivedGift {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, HashMap<String, Integer>> givenGiftMap = new HashMap<>();
        HashMap<String, Integer> giftScore = new HashMap<>();

        for(String friend : friends) {
            HashMap<String, Integer> givenCount = new HashMap<>();

            for(String f : friends) {
                givenCount.put(f, 0);
            }

            int given = 0;
            int receive = 0;
            for(String gift : gifts) {
                String[] names = gift.split(" ");

                if (names[0].equals(friend)) {
                    givenCount.put(names[1], givenCount.get(names[1]) + 1);
                    given++;
                }

                if (names[1].equals(friend)) {
                    receive++;
                }
            }

            giftScore.put(friend, given - receive);
            givenGiftMap.put(friend, givenCount);
        }

        int maxCount = 0;

        for(String key : givenGiftMap.keySet()) {
            int count = 0;

            for(String sec : givenGiftMap.get(key).keySet()) {

                int given = givenGiftMap.get(key).get(sec);
                int receive = givenGiftMap.get(sec).get(key);

                if(given == receive) {
                    if(giftScore.get(key) > giftScore.get(sec)) {
                        count++;
                    }
                } else if(given > receive) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }


        return maxCount;
    }

    public int gptSolution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(friends[i], i);
        }

        int[][] giftCounts = new int[n][n];
        int[] givenGifts = new int[n];
        int[] receivedGifts = new int[n];

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giverIdx = indexMap.get(parts[0]);
            int receiverIdx = indexMap.get(parts[1]);

            giftCounts[giverIdx][receiverIdx]++;
            givenGifts[giverIdx]++;
            receivedGifts[receiverIdx]++;
        }

        int[] giftScores = new int[n];
        for (int i = 0; i < n; i++) {
            giftScores[i] = givenGifts[i] - receivedGifts[i];
        }

        int[] nextMonthGifts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int giftAtoB = giftCounts[i][j];
                int giftBtoA = giftCounts[j][i];

                if (giftAtoB > giftBtoA) {
                    nextMonthGifts[i]++;
                } else if (giftBtoA > giftAtoB) {
                    nextMonthGifts[j]++;
                } else {
                    if (giftScores[i] > giftScores[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftScores[j] > giftScores[i]) {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }

        return Arrays.stream(nextMonthGifts).max().orElse(0);
    }

    public static void main(String[] args) {
        MostReceivedGift mostReceivedGift = new MostReceivedGift();
        String[] friends = new String[] {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(mostReceivedGift.solution(friends, gifts));
        System.out.println(mostReceivedGift.gptSolution(friends, gifts));
    }
}
