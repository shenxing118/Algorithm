package com.example.lib.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Number227 {

    public static void main(String[] args) {
        System.out.println(new Number227().calculate(" 3 / 2 + 5"));
    }

    public int calculate(String s) {
        Map<Character, Integer> operatorMap = new HashMap<>();
        operatorMap.put('+', 1);
        operatorMap.put('-', 1);
        operatorMap.put('*', 2);
        operatorMap.put('/', 2);

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int number = 0;
        for (int i = 0; i < s.length(); ) {
            if (operatorMap.containsKey(s.charAt(i))) {
                if (operators.isEmpty() || operatorMap.get(s.charAt(i)) > operatorMap.get(operators.peek())) {
                    operators.push(s.charAt(i));
                    i++;
                } else {
                    numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
                }
            } else if (s.charAt(i) != ' ') {
                number = number * 10 + Character.getNumericValue(s.charAt(i));
                i++;
                if (i == s.length() || operatorMap.containsKey(s.charAt(i)) || s.charAt(i) == ' ') {
                    numbers.push(number);
                    number = 0;
                }
            } else {
                i++;
            }
        }
        while (!operators.isEmpty()) {
            numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
        }
        return numbers.pop();
    }

    public int calculate(char operator, int num2, int num1) {
        int res;
        if (operator == '+') {
            res = num1 + num2;
        } else if (operator == '-') {
            res = num1 - num2;
        } else if (operator == '*') {
            res = num1 * num2;
        } else {
            res = num1 / num2;
        }
        return res;
    }
}
