package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number17 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4};
        print(letterCombinations("23"));
    }

    public static void print(List<String> lists) {
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i) + " , ");
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals("")) {
            return list;
        }
        String[] letterStrings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(list, digits, letterStrings, 0, "");
        return list;
    }

    public static void backTracking(List<String> list, String digits, String[] letterStrings, int pos, String tempString) {
        if (pos == digits.length()) {
            list.add(tempString);
        } else {
            String letters = letterStrings[Character.getNumericValue(digits.charAt(pos)) - 2];
            for (int i = 0; i < letters.length(); i++) {
                backTracking(list, digits, letterStrings, pos + 1, tempString + letters.charAt(i));
            }
        }
    }
}
