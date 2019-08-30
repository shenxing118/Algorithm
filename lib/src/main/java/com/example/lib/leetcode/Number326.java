package com.example.lib.leetcode;

public class Number326 {

    public static void main(String[] args) {
        System.out.println(new Number326().isPowerOfThree(45));
    }

    public boolean isPowerOfThree(int n) {
        if (n < 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
