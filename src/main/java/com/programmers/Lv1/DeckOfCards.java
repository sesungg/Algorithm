package com.programmers.Lv1;

public class DeckOfCards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean flag = false;
        int card1 = 0;
        int card2 = 0;

        for(String g : goal) {
            flag = false;
            if(card1 < cards1.length) {
                if(cards1[card1].equals(g)) {
                    card1++;
                    flag = true;
                }
            }

            if (card2 < cards2.length) {
                if(cards2[card2].equals(g)) {
                    card2++;
                    flag = true;
                }
            }

            if(!flag) {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        DeckOfCards cards = new DeckOfCards();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(cards.solution(cards1, cards2, goal));
    }

}
