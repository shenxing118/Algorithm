package com.example.lib.leetcode;

import java.util.Stack;

public class Number20 {

    public static void main(String[] args) {
        Number20 number206 = new Number20();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char popChar = stack.pop();
                    if (popChar == '(' && (c != ')') ||
                            popChar == '[' && (c != ']') ||
                            popChar == '{' && (c != '}')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
