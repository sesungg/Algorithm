package com.programmers.Lv1;

public class StringDecomposition {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            int same = 0;

            for(int j = i; j < s.length(); j++) {
                char nextWord = s.charAt(j);

                if(word == nextWord) {
                    same++;
                } else {
                    same--;
                }

                if(same == 0) {
                    i = j;
                    answer++;
                    break;
                }
            }

            if(same != 0) {
                answer++;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        StringDecomposition stringDecomposition = new StringDecomposition();

        String s1 = "banana";
        System.out.println(stringDecomposition.solution(s1)); // Output: 3

        String s2 = "abracadabra";
        System.out.println(stringDecomposition.solution(s2)); // Output: 6

        String s3 = "aaabbaccccabba";
        System.out.println(stringDecomposition.solution(s3)); // Output: 3

        String s4 = "xxxxxoooooxox";
        System.out.println(stringDecomposition.solution(s4)); // Output: 3

        String s5 = "aaaaaaaabbbvcabbabbbaasawa";
        System.out.println(stringDecomposition.solution(s5)); // Output: 2
    }
}
