package com.example.lib.leetcode;

public class Number172 {

    public static void main(String[] args) {
        System.out.println(new Number172().trailingZeroes(200));
    }

    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }
}
