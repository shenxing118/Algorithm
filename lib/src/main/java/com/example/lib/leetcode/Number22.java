package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number22 {

    public static void main(String[] args) {
        print(new Number22().generateParenthesis(3));
    }

    public static void print(List<String> lists) {
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i) + " , ");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking("", 0, 0, n, list);
        return list;
    }

    public void backtracking(String s, int leftNum, int rightNum, int n, List<String> list) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (leftNum < n) {
            backtracking(s + "(", leftNum + 1, rightNum, n, list);
        }
        if (rightNum < leftNum) {
            backtracking(s + ")", leftNum, rightNum + 1, n, list);
        }

    }
}
