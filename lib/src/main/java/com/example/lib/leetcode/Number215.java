package com.example.lib.leetcode;


public class Number215 {

    public static void main(String[] args) {
        int[] prices = new int[]{3,2,1,5,6,4};
        Number215 number215 = new Number215();
        System.out.println(number215.findKthLargest(prices, 2));
    }

    private int findKthLargest(int[] nums, int k) {
        int p = 0, r = nums.length - 1;
        int q = partition(nums, p, r);
        while (true) {
            if (q + 1 == k) {
                return nums[q];
            } else if (q + 1 < k) {
                p = q + 1;
                q = partition(nums, p, r);
            } else {
                r = q - 1;
                q = partition(nums, p, r);
            }
        }
    }

    private int partition(int[] num, int p, int r) {
        int pivot = num[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (num[j] > pivot) {
                swap(num, i, j);
                i++;
            }
        }
        swap(num, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
