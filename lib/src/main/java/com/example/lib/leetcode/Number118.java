package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Number118 {

    public static void main(String[] args) {
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);

            List<Integer> lastList = result.get(i - 1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    list.add(1);
                } else {
                    list.add(lastList.get(j - 1) + lastList.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

}
