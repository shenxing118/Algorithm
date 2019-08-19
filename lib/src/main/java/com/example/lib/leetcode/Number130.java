package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number130 {

    public static void main(String[] args) {
        char[][] board = new char[][]
                {
                        {'O', 'O', 'O', 'O', 'X', 'X'},
                        {'O', 'O', 'O', 'O', 'O', 'O'},
                        {'O', 'X', 'O', 'X', 'O', 'O'},
                        {'O', 'X', 'O', 'O', 'X', 'O'},
                        {'O', 'X', 'O', 'X', 'O', 'O'},
                        {'O', 'X', 'O', 'O', 'O', 'O'}
                };
        Number130 number130 = new Number130();
        number130.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[][] notSurround = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                dfs(board, visited, notSurround, 0, i);
            }
            if (board[board.length - 1][i] == 'O' && !visited[board.length - 1][i]) {
                dfs(board, visited, notSurround, board.length - 1, i);
            }
        }

        for (int i = 1; i < board.length; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, visited, notSurround, i, 0);
            }
            if (board[i][board[i].length - 1] == 'O' && !visited[i][board[i].length - 1]) {
                dfs(board, visited, notSurround, i, board[i].length - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !notSurround[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, boolean[][] visited, boolean[][] notSurround, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
            if (board[i][j] == 'O' && !visited[i][j]) {
                visited[i][j] = true;
                notSurround[i][j] = true;
                dfs(board, visited, notSurround, i + 1, j);
                dfs(board, visited, notSurround, i - 1, j);
                dfs(board, visited, notSurround, i, j - 1);
                dfs(board, visited, notSurround, i, j + 1);
            }
        }

    }
}
