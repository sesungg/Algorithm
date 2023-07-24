package com.programmers.Lv1;

public class PrimeSumCombinations {
    private boolean[] primeArr = new boolean[3001];

    public int mySolution(int[] nums) {
        setPrime();

        int answer = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(!primeArr[nums[i] + nums[j] + nums[k]]) answer++;
                }
            }
        }

        return answer;
    }

    private void setPrime() {
        for(int i = 2; i * i < 3001; i++) {
            for(int j = i; i * j < 3001; j++) {
                primeArr[i * j] = true;
            }
        }
    }

    public static int gptSolution(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Helper function to check if a number is prime
    private static boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
