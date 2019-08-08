package com.example.lib.leetcode;

import java.util.Arrays;
import java.util.List;

public class Number139 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        String[] dir = new String[]{"leet", "code"};
        System.out.println(longestPalindrome("leetcode", Arrays.asList(dir)));
    }

    public static boolean longestPalindrome(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (i >= wordDict.get(j).length() && dp[i - wordDict.get(j).length()]
                        && s.substring(i - wordDict.get(j).length(), i ).equals(wordDict.get(j))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }
}
