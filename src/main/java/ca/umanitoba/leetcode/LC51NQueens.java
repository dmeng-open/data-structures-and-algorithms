package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC51NQueens {
    private static final char QUEEN = 'Q', EMPTY = '.';

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(board(n), 0, result);
        return result;
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

    private void dfs(char[][] board, int c, List<List<String>> result) {
        if (c == board.length) {
            result.add(construct(board));
            return;
        }

        for (int r = 0; r < board.length; r++) {
            if (valid(board, r, c)) {
                board[r][c] = QUEEN;
                dfs(board, c + 1, result);
                board[r][c] = EMPTY;
            }
        }
    }

    private boolean valid(char[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == QUEEN) {
                    if (r == i || r + c == i + j || r - c == i - j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}
