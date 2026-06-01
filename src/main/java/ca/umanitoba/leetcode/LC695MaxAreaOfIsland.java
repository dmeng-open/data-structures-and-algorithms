package ca.umanitoba.leetcode;

public class LC695MaxAreaOfIsland {
    private static final int[][] DIRECTIONS = {
        { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result = Math.max(dfs(grid, r, c), result);
            }
        }
        
        return result;
    }

    private int dfs(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) {
            return 0;
        }
        
        grid[r][c] = 0;

        int result = 1;
        for (int[] direction : DIRECTIONS) {
            result += dfs(grid, r + direction[0], c + direction[1]);
        }

        return result;
    }
}
