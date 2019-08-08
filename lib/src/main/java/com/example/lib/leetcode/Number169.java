package com.example.lib.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Number169 {

    public static void main(String[] args) {
        int[] prices = new int[]{6, 5, 5};
        System.out.println(majorityElement2(prices));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int max = 1;
        int maxNum = nums[0];
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int value = map.get(num) + 1;
                if (value > max) {
                    max = value;
                    maxNum = num;
                }
                map.put(num, value);
            }
        }
        return maxNum;
    }

    public static int majorityElement2(int[] nums) {
        int majorityElement = nums[0];
        int majorityCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majorityCount > 0) {
                if (majorityElement == nums[i]) {
                    majorityCount++;
                } else {
                    majorityCount--;
                }
            } else if (majorityCount == 0) {
                majorityElement = nums[i];
                majorityCount++;
            }
        }
        return majorityElement;
    }

}
