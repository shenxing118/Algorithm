package com.example.lib.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Number150 {

    public static void main(String[] args) {
        System.out.println(new Number150().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for (String token : tokens) {
            if (operators.contains(token)) {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                int res;
                if (token.equals("+")) {
                    res = num1 + num2;
                } else if (token.equals("-")) {
                    res = num1 - num2;
                } else if (token.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
