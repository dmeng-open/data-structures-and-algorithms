package ca.umanitoba.leetcode;

public class LC1905CountSubIslands {
    private static final int[][] DIRECTIONS = {
        { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return true;
        }

        boolean result = grid1[i][j] == 1;
        grid2[i][j] = 0;

        for (int[] direction : DIRECTIONS) {
            result = dfs(grid1, grid2, i + direction[0], j + direction[1]);
        }
        
        return result;
    }
}
 