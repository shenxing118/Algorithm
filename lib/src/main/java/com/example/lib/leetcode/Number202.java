package com.example.lib.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Number202 {

    public static void main(String[] args) {
        Number202 number202 = new Number202();
        System.out.print(number202.isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int i = n;
        while (true) {
            int sum = 0;
            while (i > 0) {
                sum += Math.pow(i % 10,2);
                i = i / 10;
            }
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                i = sum;
            }
        }
    }
}
