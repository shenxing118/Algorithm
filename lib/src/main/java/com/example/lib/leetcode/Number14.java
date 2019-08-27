package com.example.lib.leetcode;

public class Number14 {

    public static void main(String[] args) {
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int sameIndex = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    break;
                }
            }
            if (j == strs.length) {
                sameIndex++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, sameIndex);
    }
}
