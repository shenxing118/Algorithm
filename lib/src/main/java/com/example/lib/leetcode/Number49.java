package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number49 {

    public static void main(String[] args) {
        Number49 number454 = new Number49();
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = number454.groupAnagrams2(s);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] strArray = new int[26];
            for (int i = 0; i < str.length(); i++) {
                strArray[str.charAt(i) - 'a']++;
            }
            String s = Arrays.toString(strArray);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] hashArray = new int[strs.length][26];
        int n = 0;
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean find = false;
            int[] curHash = getHash(strs[i]);
            for (int j = 0; j < n; j++) {
                if (isEqual(hashArray[j], curHash)) {
                    find = true;
                    lists.get(j).add(strs[i]);
                    break;
                }
            }
            if (!find) {
                hashArray[n++] = curHash;
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
            }
        }
        return lists;
    }

    public boolean isEqual(int[] hash1, int[] hash2) {
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getHash(String s) {
        int[] hash = new int[26];
        for (int j = 0; j < s.length(); j++) {
            hash[s.charAt(j) - 'a']++;
        }
        return hash;
    }
}
