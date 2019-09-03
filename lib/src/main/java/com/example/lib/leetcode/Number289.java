package com.example.lib.leetcode;

public class Number289 {

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Number289 number289 = new Number289();
        number289.gameOfLife(board);
        number289.print(board);
    }

    public void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int countOfLive = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (!(k == 0 && l == 0)) {
                            int r = i + k;
                            int c = j + l;
                            if ((r >= 0 && r < board.length) && (c >= 0 && c < board[i].length)
                                    && (board[r][c] & 1) == 1) {
                                countOfLive++;
                            }
                        }

                    }
                }
                if ((board[i][j] & 1) == 1 && (countOfLive == 2 || countOfLive == 3)) {
                    board[i][j] = 3;
                }
                if ((board[i][j] & 1) == 0 && countOfLive == 3) {
                    board[i][j] = 2;
                }

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((board[i][j] >> 1) == 1){
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

}
