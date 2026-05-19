package ca.umanitoba.leetcode;

public class LC52NQueensII {
    private static final char QUEEN = 'Q', EMPTY = '.';
    private int result = 0;

    public int totalNQueens(int n) {
        dfs(board(n), 0);
        return result;
    }

    private void dfs(char[][] board, int c) {
        if (c == board.length) {
            result++;
            return;
        }

        for (int r = 0; r < board.length; r++) {
            if (valid(board, r, c)) {
                board[r][c] = QUEEN;
                dfs(board, c + 1);
                board[r][c] = EMPTY;
            }
        }
    }

    private boolean valid(char[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == QUEEN) {
                    if (r == i || r - c == i - j || r + c == i + j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private char[][] board(int n) {
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = EMPTY;
            }
        }
        return board;
    }
}
