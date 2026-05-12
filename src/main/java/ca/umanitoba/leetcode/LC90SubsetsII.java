package ca.umanitoba.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LC90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, Deque<Integer> path, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            path.addLast(nums[i]);
            backtrack(nums, result, path, i + 1);
            path.removeLast();
        }
    }
}
