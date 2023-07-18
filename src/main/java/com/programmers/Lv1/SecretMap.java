package com.programmers.Lv1;

import java.util.HashMap;

public class SecretMap {
    static class Solution {
        public static String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String[] binary1 = new String[n];
            String[] binary2 = new String[n];

            for(int i = 0; i < n; i++) {
                String tem1 = Integer.toBinaryString(arr1[i]);
                String tem2 = Integer.toBinaryString(arr2[i]);
                if(tem1.length() == n) {
                    binary1[i] = Integer.toBinaryString(arr1[i]);
                } else {
                    String zero = "";
                    for(int j = 0; j < n - tem1.length(); j++) {
                        zero += "0";
                    }
                    binary1[i] = zero + Integer.toBinaryString(arr1[i]);
                }

                if(tem2.length() == n) {
                    binary2[i] = Integer.toBinaryString(arr2[i]);
                } else {
                    String zero = "";
                    for(int j = 0; j < n - tem2.length(); j++) {
                        zero += "0";
                    }
                    binary2[i] = zero + Integer.toBinaryString(arr2[i]);
                }
            }

            for(int i = 0; i < n; i++) {
                StringBuffer line = new StringBuffer();
                for(int j = 0; j < n; j++) {
                    char a = binary1[i].charAt(j);
                    char b = binary2[i].charAt(j);
                    if(a == '0' && a == b) {
                        line.append(" ");
                    } else {
                        line.append("#");
                    }
                }
                answer[i] = line.toString();
            }
            return answer;
        }

        public static String makeSharp(int n, int m) {
            if(n == 0) {
                if( m > 0) {
                    String str = "";
                    for(int i = 0; i < m; i++) {
                        str += " ";
                    }
                    return str;
                }
                else return "";
            }
            else {
                return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#";
            }
        }
        public static String[] othersSolution(int n, int [] arr1, int [] arr2) {
            String [] answer = new String[n];
            int [] secretMap = new int[n];
            for(int i = 0; i < n; i++) {
                secretMap[i] = arr1[i] | arr2[i];
                answer[i] = makeSharp(secretMap[i], n);
            }
            return answer;
        }

        public static String[] othersSolution2(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String temp;

            for(int i = 0 ; i < n ; i++){
                temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
                temp = temp.substring(temp.length() - n);
                temp = temp.replaceAll("1", "#");
                temp = temp.replaceAll("0", " ");
                answer[i] = temp;
            }

            return answer;
        }

        public static String[] gptSolution(int n, int[] arr1, int[] arr2) {
            String[] secretMap = new String[n];

            for (int i = 0; i < n; i++) {
                // Convert each element of arr1 and arr2 to binary strings
                String binary1 = Integer.toBinaryString(arr1[i]);
                String binary2 = Integer.toBinaryString(arr2[i]);

                // Pad zeros at the beginning if the binary strings are shorter than n
                binary1 = String.format("%" + n + "s", binary1).replace(' ', '0');
                binary2 = String.format("%" + n + "s", binary2).replace(' ', '0');

                StringBuilder row = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    // If either binary digit is '1', it represents a wall ('#')
                    if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
                        row.append("#");
                    } else {
                        row.append(" ");
                    }
                }

                secretMap[i] = row.toString();
            }

            return secretMap;
        }

        public static void main(String[] args) {
            int n = 5;
            int[] arr1 = {9, 20, 28, 18, 11};
            int[] arr2 = {30, 1, 21, 17, 28};

            String[] decodedMap = othersSolution(n, arr1, arr2);

            // Print the decoded secret map
            for (String row : decodedMap) {
                System.out.println(row);
            }
        }
    }
}
