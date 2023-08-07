package com.programmers.Lv1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindPersonalInformationToBeDestroyed {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();

        HashMap<String, Integer> map = new HashMap<>();

        for(String term : terms) {
            map.put(term.substring(0, 1), Integer.parseInt(term.substring(2)));
        }

        for(int i = 0; i < privacies.length; i++) {
            String privacie = privacies[i];

            int period = map.get(privacie.substring(privacie.indexOf(" ") + 1));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

            LocalDate date = LocalDate.parse(privacie.substring(0, privacie.indexOf(" ")), formatter);

            LocalDate newDate = date.plusMonths(period);

            String newDateString = newDate.format(formatter);

            int comparisonResult = newDateString.compareTo(today);

            if(comparisonResult <= 0) {
                answer.add(i + 1);
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        FindPersonalInformationToBeDestroyed sol = new FindPersonalInformationToBeDestroyed();

        List<Integer> result = sol.solution(today, terms, privacies);

        for (Integer re : result) {
            System.out.println("result = " + re);
        }
    }
}
