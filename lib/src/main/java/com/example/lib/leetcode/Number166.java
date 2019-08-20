package com.example.lib.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Number166 {

    public static void main(String[] args) {
        System.out.println(new Number166().fractionToDecimal(-1, -2147483648));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append((numerator > 0) ^ (denominator > 0) ? "-" : "");

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        result.append(num / den);
        num = num % den;

        if (num == 0) {
            return result.toString();
        } else {
            result.append(".");
        }


        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            num *= 10;
            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
                result.append(num / den);
            }
            num = num % den;
        }
        return result.toString();
    }



}
