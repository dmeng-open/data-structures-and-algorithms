package ca.umanitoba.leetcode;

public class LC733FloodFill {
    private static final int[][] DIRECTIONS = {
        { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        if (start == color) return image;
        dfs(image, sr, sc, start, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int start, int color) {
        int m = image.length, n = image[0].length;
        if (r < 0 || c < 0 || r >= m || c <= n || image[r][c] != start) {
            return;
        }

        image[r][c] = color;

        for (int[] direction : DIRECTIONS) {
            dfs(image, r + direction[0], c + direction[1], start, color);
        }
    }
}
