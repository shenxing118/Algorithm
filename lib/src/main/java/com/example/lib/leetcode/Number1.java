package com.example.lib.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Number1 {

    public static void main(String[] args) {
        Number1 number202 = new Number1();
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (target == nums[i] * 2) {
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    return result;
                }
            } else {
                map.put(nums[i], i);
            }
        }

        for (int num : map.keySet()) {
            if (map.containsKey(target - num)) {
                result[0] = map.get(num);
                result[1] = map.get(target - num);
            }
        }
        return result;
    }
}
