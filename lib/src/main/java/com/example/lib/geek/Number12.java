package com.example.lib.geek;

public class Number12 {

    public static void main(String[] args) {
        Number12 number12 = new Number12();

        int[] nums = new int[]{34, 56, 31, 23, 7, 3, 1, 24};
        number12.quickSort(nums, 0, nums.length - 1);

        number12.print(nums);
    }

    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " , ");
        }
    }

    private void quickSort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            quickSort(nums, p, q - 1);
            quickSort(nums, q + 1, r);
        }
    }

    private int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    private void mergeSort(int[] nums, int p, int r) {
        if (p >= r) return;

        int q = (p + r) / 2;
        mergeSort(nums, p, q);
        System.out.println("mergesort" + p + "--" + q);
        mergeSort(nums, q + 1, r);
        System.out.println("mergesort" + (q + 1) + "--" + r);
        merge(nums, p, q, r);
        System.out.println("merge" + (p) + "--" + r);
    }

    private void merge(int[] nums, int p, int q, int r) {
        int[] temp = new int[r - p + 1];
        int tempIndex = 0;
        int i = p, j = q + 1;
        while (i <= q && j <= r) {
            if (nums[i] < nums[j]) {
                temp[tempIndex++] = nums[i++];
            } else {
                temp[tempIndex++] = nums[j++];
            }
        }

        if (i > q) {
            for (int k = j; k <= r; k++) {
                temp[tempIndex++] = nums[j++];
            }
        } else {
            for (int k = i; k <= q; k++) {
                temp[tempIndex++] = nums[i++];
            }
        }

        for (int m = 0; m < temp.length; m++) {
            nums[p + m] = temp[m];
        }
    }

}
