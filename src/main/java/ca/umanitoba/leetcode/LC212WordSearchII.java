package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC212WordSearchII {
    private static final char A = 'a', USED = '.';
    private final int[][] shifts = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private String word;        
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = toTrie(words);
        List<String> result = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                search(board, root, result, r, c);
            }
        }
        return result;
    }

    private void search(char[][] board, TrieNode root, List<String> result, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == USED) {
            return;
        }
        TrieNode node = root.children[board[r][c] - A];
        if (node == null) {
            return;
        }
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        char previous = board[r][c];
        board[r][c] = USED;
        for (int[] shift : shifts) {
            search(board, node, result, r + shift[0], c + shift[1]);
        }
        board[r][c] = previous;
    }

    private TrieNode toTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char character : word.toCharArray()) {
                int index = character - A;
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }
}
