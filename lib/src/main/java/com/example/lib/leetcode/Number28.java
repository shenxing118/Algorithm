package com.example.lib.leetcode;

public class Number28 {

    public static void main(String[] args) {
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (i + needle.length() > haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
