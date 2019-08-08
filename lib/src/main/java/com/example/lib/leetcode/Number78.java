package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number78 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4};
        print(subsets(prices));
        System.out.println(count);
    }

    public static int count = 0;

    public static void print(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " , ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtracking(nums, lists, new ArrayList<Integer>(), 0);
        return lists;
    }

    public static void backtracking(int[] nums, List<List<Integer>> lists, List<Integer> tempList, int startPos) {
        count++;
        lists.add(new ArrayList<>(tempList));
        for (int i = startPos; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(nums, lists, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }
}
