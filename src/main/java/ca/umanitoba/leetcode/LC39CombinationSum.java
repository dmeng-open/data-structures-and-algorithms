package ca.umanitoba.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 2 3 6 7 | 7
// 2 2 3 = 7
// 2 3 2 = 7
// 3 2 2 = 7
public class LC39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        search(candidates, target, path, 0, result);
        return result;
    }

    private void search(int[] options, int target, Deque<Integer> path, int start, List<List<Integer>> result) {
        if (target == 0) 
            result.add(new ArrayList<>(path));
        else
            for (int i = start; i < options.length; i++) {
                if (options[i] > target) continue;
                path.addLast(options[i]);
                search(options, target - options[i], path, i, result);
                path.removeLast();
            }
    }
}
