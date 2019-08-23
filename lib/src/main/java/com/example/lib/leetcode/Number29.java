package com.example.lib.leetcode;

public class Number29 {

    public static void main(String[] args) {
        System.out.println(new Number29().divide(-2147483648, 1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long count = 0;
        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        while (divid >= divis) {
            long sum = divis;
            long tempCount = 1;
            while (sum << 1 <= divid) {
                sum <<= 1;
                tempCount <<= 1;
            }
            count += tempCount;
            divid = divid - sum;
        }
        return (int) (sign * count);

    }
}
