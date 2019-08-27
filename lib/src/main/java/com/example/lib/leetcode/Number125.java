package com.example.lib.leetcode;

public class Number125 {

    public static void main(String[] args) {
        System.out.println(new Number125().isPalindrome("0P"));
        System.out.println('0');
        System.out.println('9');
        System.out.println('0' - 'a');
        System.out.println('0' - 'A');
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !isAlphanumberic(s.charAt(i))) {
                i++;
            }
            while (j > i && !isAlphanumberic(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isAlphanumberic(char c) {
        return (c - 'a' >= 0 && c - 'a' <= 25) || (c - 'A' >= 0 && c - 'A' <= 25)
                || (c - '0' >= 0 && c - '0' <= 9);
    }

}
