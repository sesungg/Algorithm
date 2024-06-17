package com.searchAlgorithm.KMP;

public class KMP {
    public int[] computeLPSArray(String pat) {
        int len = 0;
        int i = 1;
        int[] lps = new int[pat.length()];

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = len++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = len;
                }
            }
        }

        return lps;
    }

    public void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int[] lps = computeLPSArray(pat);

        int i = 0;
        int j = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP().KMPSearch(pat, txt);
    }
}
