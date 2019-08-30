package com.example.lib.leetcode;

public class Number8 {

    public static void main(String[] args) {
        System.out.println(new Number8().myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        int sign = 1;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (!Character.isDigit(str.charAt(i))) {
            return 0;
        }

        long num = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            num = num * 10 + Character.getNumericValue(str.charAt(i));
            i++;
            if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
                break;
            }
        }

        num = sign * num;
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) num;
        }

    }
}
