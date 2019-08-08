package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number46 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3};
        print(permute(prices));
    }

    public static void print(List<List<Integer>> lists){
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " , ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtracking(nums, lists, new ArrayList<Integer>());
        return lists;
    }

    public static void backtracking(int[] nums, List<List<Integer>> lists, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    backtracking(nums, lists, tempList);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
