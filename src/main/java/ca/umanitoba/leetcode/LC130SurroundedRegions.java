package ca.umanitoba.leetcode;

public class LC130SurroundedRegions {
    private static final int[][] DIRECTIONS = {
        { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int r = 0; r < m; r++) {
            dfs(board, r, 0);
            dfs(board, r, n - 1);
        }

        for (int c = 0; c < n; c++) {
            dfs(board, 0, c);
            dfs(board, m - 1, c);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int m = board.length, n = board[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] == '.' || board[r][c] == 'X') {
            return;
        }

        board[r][c] = '.';

        for (int[] direction : DIRECTIONS) {
            dfs(board, r + direction[0], c + direction[1]);
        }
    }
}
