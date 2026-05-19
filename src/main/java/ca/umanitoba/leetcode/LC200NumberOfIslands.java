package ca.umanitoba.leetcode;

public class LC200NumberOfIslands {
    private static final int[][] SHIFTS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        for (int[] SHIFT : SHIFTS) {
            int y = r + SHIFT[0], x = c + SHIFT[1];
            if (y < 0 || x < 0 || y >= grid[0].length || x >= grid.length || grid[y][x] == '0') continue;
            dfs(grid, y, x);
        }
    }
}
