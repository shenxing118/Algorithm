package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number22 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3};
        print(generateParenthesis(3));
    }

    public static void print(List<String> lists) {
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i) + " , ");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(n, list, "", 0, 0);
        return list;
    }

    public static void backtracking(int n, List<String> list, String string, int leftNum, int rightNumber) {
        if (string.length() == n * 2) {
            list.add(string);
        } else {
            if (leftNum < n) {
                backtracking(n, list, string + '(', leftNum + 1, rightNumber);
            }
            if (rightNumber < leftNum) {
                backtracking(n, list, string + ')', leftNum, rightNumber + 1);
            }
        }
    }
}
