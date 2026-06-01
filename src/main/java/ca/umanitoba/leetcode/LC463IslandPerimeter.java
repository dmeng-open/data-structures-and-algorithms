package ca.umanitoba.leetcode;

public class LC463IslandPerimeter {
    private static final int[][] DIRECTIONS = {
        { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }
    };

    private int perimeter = 0;

    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c);
                    break;
                }
            }
        }

        return perimeter;
    }

    private void dfs(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;

        grid[r][c] = -1;

        for (int[] direction : DIRECTIONS) {
            int i = r + direction[0], j = c + direction[1];
            if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
                perimeter++;
                continue;
            }

            if (grid[i][j] == -1) {
                continue;
            }

            dfs(grid, i, j);
        }
    }
}
