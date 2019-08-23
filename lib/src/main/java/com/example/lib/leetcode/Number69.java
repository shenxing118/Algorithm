package com.example.lib.leetcode;

public class Number69 {

    public static void main(String[] args) {
        System.out.println(new Number69().mySqrt(4));
    }

    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int i = 1, j = x;
        while (true) {
            int mid = (i + j) / 2;
            if (mid <= x / mid) {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
    }
}
