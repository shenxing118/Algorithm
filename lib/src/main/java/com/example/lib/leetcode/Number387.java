package com.example.lib.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Number387 {

    public static void main(String[] args) {
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), -1);
            }
        }
        for (Integer pos : map.values()) {
            if (pos != -1) {
                return pos;
            }
        }
        return -1;
    }
}
