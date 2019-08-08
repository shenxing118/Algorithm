package com.example.lib.leetcode;

import java.util.Arrays;

public class Number242 {

    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCount = new int[24];
        int[] tCount = new int[24];
        for (char c : s.toCharArray()) {
            sCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tCount[c - 'a']++;
        }

        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return true;
    }
}
