package ca.umanitoba.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, result, new ArrayDeque<>(), 1, k);
        return result;
    }

    private void backtrack(int n, List<List<Integer>> result, Deque<Integer> path, int start, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // [] | [1 2 3]
        // [1] | [2 3]
        // [1 2]
        // [1] | [3]
        // [1 3]
        // [] | [2 3]
        // [2] | [3]
        // [2 3]
        // [] | [3]
        // [3]
        // []
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backtrack(n, result, path, i + 1, k);
            path.removeLast();
        }
    }
}
