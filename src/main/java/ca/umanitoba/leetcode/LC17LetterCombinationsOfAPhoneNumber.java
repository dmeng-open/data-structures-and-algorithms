package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC17LetterCombinationsOfAPhoneNumber {
    private static final char ZERO = '0';
    private String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        search(digits, path, result, 0);
        return result;
    }

    private void search(String levels, StringBuilder path, List<String> result, int index) {
        if (path.length() == levels.length()) result.add(path.toString());
        else {
            String options = map[levels.charAt(index) - ZERO];
            for (int i = 0; i < options.length(); i++) {
                char option = options.charAt(i);
                path.append(option);
                search(levels, path, result, index + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
