package com.example.lib.leetcode;

public class Number50 {

    public static void main(String[] args) {
        System.out.println(new Number50().myPow(2, -2147483648));
        System.out.println(Math.pow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
