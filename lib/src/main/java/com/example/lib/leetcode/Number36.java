package com.example.lib.leetcode;

public class Number36 {

    public static void main(String[] args) {

        String s = "[\n" +
                "  [\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                "]";

        System.out.println(s.replaceAll("\"", "\'").replaceAll("[\\[]", "{")
                .replaceAll("[\\]]", "}"));

        char[][] chars = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(new Number36().isValidSudoku(chars));

    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] row = new int[9];
            int[] column = new int[9];
            int[] box = new int[9];
            for (int j = 0; j < board[i].length; j++) {
                int boxi = i / 3 * 3 + j / 3;
                int boxj = i % 3 * 3 + j % 3;
                if (checkRepeat(row, board[i][j]) || checkRepeat(column, board[j][i])
                        || checkRepeat(box, board[boxi][boxj])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRepeat(int[] hash, char c) {
        if (c != '.') {
            if (hash[c - '1'] == 1) {
                return true;
            } else {
                hash[c - '1'] = 1;
            }
        }
        return false;
    }
}
