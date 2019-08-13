package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number350 {

    public static void main(String[] args) {
        int[] prices1 = new int[]{54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41};
        int[] prices2 = new int[]{17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,
                84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20};
        print(intersect(prices1, prices2));
    }

    public static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " , ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        for (int num : nums1) {
            if (firstMap.containsKey(num)) {
                firstMap.put(num, firstMap.get(num) + 1);
            } else {
                firstMap.put(num, 1);
            }
        }
        int i = 0;
        for (int num : nums2) {
            if (firstMap.containsKey(num)) {
                result[i++] = num;
                if (firstMap.get(num) == 1) {
                    firstMap.remove(num);
                } else {
                    firstMap.put(num, firstMap.get(num));
                }
            }

        }
        int[] resultArray = new int[i];
        for (int j = 0; j < i; j++) {
            resultArray[j] = result[j];
        }
        return resultArray;
    }
}
