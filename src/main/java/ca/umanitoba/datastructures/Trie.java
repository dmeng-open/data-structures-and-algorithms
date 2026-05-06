package ca.umanitoba.datastructures;

public class Trie {
    private static class TrieNode {
        private boolean isWord;
        private TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();

    public void add(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isWord = true;
    }

    public boolean contains(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) return false;
            node = node.children[i];
        }
        return node.isWord;
    }

    public boolean startsWith(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                return false;
            node = node.children[i];
        }
        return true;
    }
}
