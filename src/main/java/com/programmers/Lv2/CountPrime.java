package com.programmers.Lv2;

import java.util.HashSet;
import java.util.Iterator;

public class CountPrime {
    HashSet<Integer> numberSet = new HashSet<>();

    private void recursive(String comb, String others) {
        if(!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }

        for(int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다.
        if(num == 0 || num == 1) {
            return false;
        }

        // 2. 에라토스테네스의 체의 limit을 계산한다.
        int lim = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
        for(int i = 2; i <= lim; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(String numbers) {
        int count = 0;

        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();

        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrime CountPrime = new CountPrime();
        System.out.println(CountPrime.solution("17"));

        System.out.println(CountPrime.numberSet);
    }
}
