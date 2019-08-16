package com.example.lib.leetcode;

public class Number324 {

    public static void main(String[] args) {
        int[] prices = new int[]{4, 5, 5, 6};
        Number324 number324 = new Number324();
        number324.wiggleSort(prices);
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " , ");
        }
    }

    public void wiggleSort2(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int[] tmpArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > median) {
                tmpArr[odd] = nums[i];
                odd += 2;
                continue;
            }
            if (nums[i] < median) {
                tmpArr[even] = nums[i];
                even -= 2;
                continue;
            }
        }
        while (odd < nums.length) {
            tmpArr[odd] = median;
            odd += 2;
        }
        while (even >= 0) {
            tmpArr[even] = median;
            even -= 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArr[i];
        }
    }

    public void wiggleSort(int[] nums) {
        int mid = findKthLargest(nums, nums.length / 2 + 1);
        int[] temp = new int[nums.length];
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mid) {
                temp[even] = nums[i];
                even -= 2;
            } else if (nums[i] > mid) {
                temp[odd] = nums[i];
                odd += 2;
            }
        }

        while (even >= 0) {
            temp[even] = mid;
            even -= 2;
        }

        while (odd < nums.length) {
            temp[odd] = mid;
            odd += 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    private int findKthLargest(int[] nums, int k) {

        int p = 0, r = nums.length - 1;

        while (p < r) {
            int q = partition(nums, p, r);
            if (q + 1 == k) {
                break;
            } else if (q + 1 > k) {
                r = q - 1;
            } else {
                p = q + 1;
            }
        }
        return nums[k - 1];

    }

    private int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;

    }


}
