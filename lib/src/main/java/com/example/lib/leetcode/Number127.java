package com.example.lib.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Number127 {

    public static void main(String[] args) {
        String[] strings = new String[]{"hot", "dot", "dog", "lot", "log"};
        Number127 number130 = new Number127();
        System.out.println(number130.ladderLength("hit", "cog", Arrays.asList(strings)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        int trasformTimes = 1;
        int levelCount = 1;
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals(endWord)) {
                return trasformTimes;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (visited[i]) continue;
                int diffIndex = getSingleDiffIndex(s, wordList.get(i));
                if (diffIndex >= 0) {
                    queue.add(wordList.get(i));
                    visited[i] = true;
                }
            }
            levelCount--;
            if (levelCount == 0) {
                levelCount = queue.size();
                trasformTimes++;
            }
        }
        return 0;
    }

    private int getSingleDiffIndex(String firstWord, String secondWord) {
        int diffCount = 0;
        int diffIndex = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                diffCount++;
                diffIndex = i;
                if (diffCount > 1) {
                    return -1;
                }
            }
        }
        return diffCount == 0 ? -2 : diffIndex;
    }
}
