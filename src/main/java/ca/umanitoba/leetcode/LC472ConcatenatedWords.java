package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC472ConcatenatedWords {
    private static class TrieNode {
        private boolean isWord;
        private TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) insert(word);
        for (String word : words) if (search(word, 0, 0)) result.add(word);
        return result;
    }

    private boolean search(String word, int start, int count) {
        if (start == word.length() && count > 1) return true;
        int size = word.length();
        TrieNode node = root;
        for (int i = start; i < size; i++) {
            char character = word.charAt(i);
            int index = character - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
            if (node.isWord && search(word, i + 1, count + 1)) return true;
        }
        return false;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char character : word.toCharArray()) {
            int index = character - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isWord = true;
    }
}
