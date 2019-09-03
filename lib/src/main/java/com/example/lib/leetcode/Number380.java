package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Number380 {

    public static void main(String[] args) {
    }

    class RandomizedSet {

        ArrayList<Integer> nums;
        HashMap<Integer, Integer> pos;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            pos = new HashMap<>();
            nums = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (pos.containsKey(val)) {
                return false;
            } else {
                nums.add(val);
                pos.put(val, nums.size() - 1);
                return true;
            }
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (pos.containsKey(val)) {
                int index = pos.get(val);

                int lastIndex = nums.size() - 1;
                if (index != lastIndex) {
                    pos.put(nums.get(nums.size() - 1), index);
                    nums.set(index, nums.get(nums.size() - 1));
                }

                pos.remove(val);
                nums.remove(lastIndex);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));

        }
    }
}
