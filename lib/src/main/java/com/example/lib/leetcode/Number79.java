package com.example.lib.leetcode;

public class Number79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        int[][] tags = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, word, tags, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backTracking(char[][] board, String word, int[][] tags, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        } else {
            search(board, word, tags, i + 1, j, pos + 1);
            search(board, word, tags, i - 1, j, pos + 1);
            search(board, word, tags, i, j + 1, pos + 1);
            search(board, word, tags, i, j - 1, pos + 1);
            return false;
        }
    }

    public static boolean search(char[][] board, String word, int[][] tags, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }

        boolean exist = false;

        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length
                && board[i][j] == word.charAt(pos) && tags[i][j] == 0) {
            tags[i][j] = 1;
            exist = search(board, word, tags, i + 1, j, pos + 1)
                    || search(board, word, tags, i - 1, j, pos + 1)
                    || search(board, word, tags, i, j + 1, pos + 1)
                    || search(board, word, tags, i, j - 1, pos + 1);
            tags[i][j] = 0;
        }
        return exist;
    }
}
