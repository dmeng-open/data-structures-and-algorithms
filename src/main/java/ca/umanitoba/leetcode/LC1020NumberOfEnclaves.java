package ca.umanitoba.leetcode;

public class LC1020NumberOfEnclaves {
    private static final int[][] DIRECTIONS = {
        { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r++) {
            dfs(grid, r, 0);
            dfs(grid, r, n - 1);
        }

        for (int c = 0; c < n; c++) {
            dfs(grid, 0, c);
            dfs(grid, m - 1, c);
        }

        int result = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;

        for (int[] direction : DIRECTIONS) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }
}
