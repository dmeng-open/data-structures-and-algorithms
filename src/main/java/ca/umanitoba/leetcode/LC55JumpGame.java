package ca.umanitoba.leetcode;

public class LC55JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0, last = nums.length - 1;
        for (int i = 0; i < last; i++) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
            if (max >= last) return true;
        }
        return true;
    }
}
