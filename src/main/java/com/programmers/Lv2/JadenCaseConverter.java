package com.programmers.Lv2;

public class JadenCaseConverter {
    public String mySolution(String s) {
        // 대문자 : 65 - 90
        // 소문자 : 97 - 122
        // 공백 : 32
        // 숫자 : 48 - 57
        char[] arr = s.toCharArray();
        if(arr[0] >= 97 && arr[0] <= 122) {
            arr[0] = (char) (arr[0] - 32);
        }

        for(int i = 1; i < arr.length; i++) {
            char prevChar = arr[i - 1];
            char c = arr[i];
            if (prevChar == 32) {
                if (c >= 97 && c <= 122) {
                    arr[i] = (char) (c - 32);
                }
            } else if(c >= 65 && c <= 90) {
                arr[i] = (char) (c + 32);
            }
        }

        return new String(arr);
    }

    public String otherSolution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }

    public String gptSolution(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(capitalizeNext ? Character.toUpperCase(c) : Character.toLowerCase(c));
                capitalizeNext = false;
            } else if (c == ' ') {
                result.append(c);
                capitalizeNext = true;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        JadenCaseConverter caseConverter = new JadenCaseConverter();

        String test1Input = "3people unFollowed me";
        String test2Input = "for the last week";

        String test1Output = caseConverter.mySolution(test1Input);
        String test2Output = caseConverter.mySolution(test2Input);

        System.out.println("Test 1: " + test1Output);
        System.out.println("Test 2: " + test2Output);
    }
}
