package com.example.lib.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Number13 {

    public static void main(String[] args) {
        System.out.println(new Number13().romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int j = 1; j < s.length(); j++) {
            if (map.get(s.charAt(j)) > map.get(s.charAt(j - 1))) {
                sum -= map.get(s.charAt(j - 1));
            } else {
                sum += map.get(s.charAt(j - 1));
            }
        }
        sum += map.get(s.charAt(s.length() - 1));
        return sum;

    }
}
