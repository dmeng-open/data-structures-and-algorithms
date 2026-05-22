package ca.umanitoba.leetcode;

public class LC79WordSearch {
    private static final char USED = '.';
    private final int[][] shifts = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[r].length; c++)
                if (search(board, word, 0, r, c)) return true;
        return false;
    }

    private boolean search(char[][] board, String word, int index, int r, int c) {
        if (index == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) return false;
        char previous = board[r][c];
        board[r][c] = USED;
        for (int[] shift : shifts)
            if (search(board, word, index + 1, r + shift[0], c + shift[1])) return true; // Optionally restore the board
        board[r][c] = previous;
        return false;
    }
}
