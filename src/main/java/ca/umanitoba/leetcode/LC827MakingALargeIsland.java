package ca.umanitoba.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LC827MakingALargeIsland {
    private static int[][] SHIFTS = {
        { -1, 0 },
        { 0, -1 },
        { 1, 0 },
        { 0, 1 }
    };

    public int largestIsland(int[][] grid) {
        var n = grid.length;
        var key = 2;
        var result = 0;
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, key);
                    map.put(key, area);
                    result = Math.max(result, area);
                    key++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    var used = new HashSet<Integer>();
                    int area = 1;
                    for (var shift : SHIFTS) {
                        var r = i + shift[0];
                        var c = j + shift[1];
                        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] == 0 || used.contains(grid[r][c])) continue;
                        used.add(grid[r][c]);
                        area += map.getOrDefault(grid[r][c], 0);
                    }
                    result = Math.max(result, area);
                }
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j, int key) {
        var n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = key;
        var result = 1;
        for (var shift : SHIFTS) result += dfs(grid, i + shift[0], j + shift[1], key);
        return result;
    }
}