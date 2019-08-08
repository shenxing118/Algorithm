package com.example.lib.leetcode;

public class Number134 {

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            tank += diff;
            total += diff;
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }
}
