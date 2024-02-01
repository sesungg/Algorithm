package com.programmers.Lv2;

import java.util.Arrays;

public class RescueBoat {
    public int mySolution(int[] people, int limit) {
        int answer = 0;
        int i = 0;
        int j = people.length - 1;

        Arrays.sort(people);

        while(i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }

            j--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        RescueBoat rescueBoat = new RescueBoat();
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(rescueBoat.mySolution(people, limit)); // 출력: 3
    }
}
