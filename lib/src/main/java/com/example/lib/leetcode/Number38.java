package com.example.lib.leetcode;

public class Number38 {

    public static void main(String[] args) {
        System.out.println(new Number38().countAndSay(4));

    }

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0, k = 0; j < res.length(); ) {
                int count = 0;
                while (k < res.length() && res.charAt(j) == res.charAt(k)) {
                    count++;
                    k++;
                }
                stringBuilder.append(count).append(res.charAt(j));
                j = k;
            }
            res = stringBuilder.toString();
        }
        return res;

    }
}
