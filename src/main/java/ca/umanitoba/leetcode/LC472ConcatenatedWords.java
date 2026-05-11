package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC472ConcatenatedWords {
    private static class TrieNode {
        private boolean ended;
        private TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (concatenatable(word, new Boolean[word.length()], 0)) {
                result.add(word);
            }
            add(word);
        }
        return result;
    }

    private boolean concatenatable(String word, Boolean[] cache, int start) {
        if (start == word.length()) {
            return true;
        }
        if (cache[start] != null) {
            return cache[start];
        }
        TrieNode current = root;
        for (int i = start; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                break;
            }
            current = current.children[index];
            if (current.ended) {
                if (concatenatable(word, cache, i + 1)) { // DFS 尝试不同路径 catsdog - { cat + sdog } = F | { cats + dog } = T
                    cache[start] = true;
                    return true;
                }
            }
        }
        cache[start] = false;
        return false;
    }

    private void add(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            int index = character - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.ended = true;
    }
}
