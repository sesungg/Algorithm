package com.programmers.Lv2;

public class FindPrimeNumByBaseNum {
    public static boolean primeNumber(long n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int mySolution(int n, int k) {
        int answer = 0;
        String[] numArr = Integer.toString(n, k).split("0");

        for (String num : numArr) {
            if (!num.equals("1") && !num.isEmpty()) {
                if (primeNumber(Long.parseLong(num))) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FindPrimeNumByBaseNum findPrimeNumCount = new FindPrimeNumByBaseNum();
        System.out.println(findPrimeNumCount.mySolution(437674, 3));
        System.out.println(findPrimeNumCount.mySolution(110011, 10));
    }
}
