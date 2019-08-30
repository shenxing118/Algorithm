package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number15 {

    public static void main(String[] args) {
        new Number15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        lists.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] > sum) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return lists;
    }
}
