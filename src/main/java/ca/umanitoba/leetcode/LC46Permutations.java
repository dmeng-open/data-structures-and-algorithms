package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> buffer) {
        if (buffer.size() == nums.length) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            buffer.add(nums[i]);
            backtrack(nums, used, result, buffer);
            used[i] = false;
            buffer.remove(buffer.size() - 1);
        }
    }
}
