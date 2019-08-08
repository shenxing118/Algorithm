package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number131 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4};
        print(partition("aab"));
    }

    public static void print(List<List<String>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " , ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        backTracking(lists, s, 0, new ArrayList<String>());
        return lists;
    }

    public static void backTracking(List<List<String>> list, String s, int i, List<String> tempStrings) {
        if (i == s.length()) {
            list.add(new ArrayList<>(tempStrings));
        } else {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isPalindrome(subString)) {
                    tempStrings.add(subString);
                    backTracking(list, s, j + 1, tempStrings);
                    tempStrings.remove(tempStrings.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
