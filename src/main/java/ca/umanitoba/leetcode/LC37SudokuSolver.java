package ca.umanitoba.leetcode;

public class LC37SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') continue;
                for (char option = '1'; option <= '9'; option++) {
                    if (valid(board, option, i, j)) {
                        board[i][j] = option;
                        if (solve(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean valid(char[][] board, char option, int i, int j) {
        for (int c = 0; c < board[0].length; c++)
            if (board[i][c] == option) return false;
        for (int r = 0; r < board.length; r++)
            if (board[r][j] == option) return false;
        for (int r = (i / 3) * 3; r < (i / 3) * 3 + 3; r++)
            for (int c = (j / 3) * 3; c < (j / 3) * 3 + 3; c++)
                if (board[r][c] == option) return false;
        return true;
    }
}
