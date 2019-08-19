package com.example.lib.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Number217 {

    public static void main(String[] args) {
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num :
                nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
