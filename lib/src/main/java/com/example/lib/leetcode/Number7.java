package com.example.lib.leetcode;

public class Number7 {

    public static void main(String[] args) {
        System.out.println(new Number7().reverse(-123));
    }

    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        long result = 0;
        x = Math.abs(x);
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = sign * result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }else {
            return (int) result;
        }
    }
}
