package com.example.lib.leetcode;

import java.util.Stack;

public class Number155 {

    public static void main(String[] args) {
        Number155 number202 = new Number155();
    }

    class MinStack {

        private int min;
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            min = Integer.MAX_VALUE;
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                min = x;
                minStack.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            int popVal = stack.pop();
            if (popVal == min) {
                minStack.pop();
                min = !minStack.isEmpty() ? minStack.peek() : Integer.MAX_VALUE;
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
