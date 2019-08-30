package com.example.lib.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Number3 {

    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(number3.lengthOfLongestSubstring3("bbb"));
    }

    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        int max = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (posMap.containsKey(s.charAt(j))) {
                i = Math.max(posMap.get(s.charAt(j)) + 1, i);
            }
            posMap.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        int maxLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int lastIndex = map.get(s.charAt(i));
                for (int j = i - dp[i - 1]; j <= lastIndex; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(s.charAt(i), i);
                dp[i] = i - lastIndex;
            } else {
                map.put(s.charAt(i), i);
                dp[i] = dp[i - 1] + 1;
                maxLength = Math.max(dp[i], maxLength);
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
