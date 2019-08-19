package com.example.lib.leetcode;

public class Number200 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        Number200 number200 = new Number200();
        System.out.println(number200.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
            if (grid[i][j] == '1' && !visited[i][j]) {
                visited[i][j] = true;
                dfs(grid, i + 1, j, visited);
                dfs(grid, i, j + 1, visited);
            }
        }
    }
}
