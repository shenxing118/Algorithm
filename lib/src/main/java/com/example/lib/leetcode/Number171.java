package com.example.lib.leetcode;

public class Number171 {

    public static void main(String[] args) {
    }

    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + val;
        }
        return sum;
    }
}
