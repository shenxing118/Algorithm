package com.example.lib.leetcode;

public class Number5 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(longestPalindrome("aacadefcaa"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0){
            return "";
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxlen = 1;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                maxlen = 2;
                maxStart = i;
            }
        }

        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                    if (maxlen < l) {
                        maxlen = l;
                        maxStart = i;
                    }
                }
            }
        }

        return s.substring(maxStart, maxStart + maxlen);

    }

    private static void print(boolean[][] isPalindrome) {
        for (int i = 0; i < isPalindrome.length; i++) {
            for (int j = 0; j < isPalindrome[i].length; j++) {
                System.out.print(isPalindrome[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
