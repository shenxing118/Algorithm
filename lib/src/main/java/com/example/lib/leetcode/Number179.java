package com.example.lib.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Number179 {

    public static void main(String[] args) {
        int[] prices = new int[]{3,30,34,5,9};
        Number179 number179 = new Number179();
        System.out.println(number179.largestNumber(prices));
    }

    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(stringNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (stringNums[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stringNums) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();

    }

}
