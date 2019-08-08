package com.example.lib.leetcode;

public class Number91 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(numDecodings("0"));
    }

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0'){
            return 0;
        }

        int[] num = new int[s.length() + 1];

        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    num[i] = num[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (Integer.parseInt(s.substring(i - 2, i)) <= 26
                        && s.charAt(i - 2) != '0') {
                    num[i] = num[i - 1] + num[i - 2];
                } else {
                    num[i] = num[i - 1];
                }
            }
        }

        return num[s.length()];

    }

}
