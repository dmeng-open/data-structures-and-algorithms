package ca.umanitoba.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1723FindMinimumTimeToFinishAllJobs {
    private int result = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] workloads = new int[k];
        dfs(jobs, workloads, jobs.length - 1);
        return result;
    }

    private void dfs(int[] jobs, int[] workloads, int selector) {
        int max = max(workloads);

        // 终止条件
        if (selector < 0) {
            result = Math.min(result, max);
            return;
        }

        // 剪枝：不会比当前全局结果更优的分支
        if (max >= result) return;

        int job = jobs[selector];
        Set<Integer> set = new HashSet<>();
        // 确定选项范围
        for (int i = 0; i < workloads.length; i++) {
            // 剪枝：减掉等价的分支
            if (set.contains(workloads[i])) continue;
            set.add(workloads[i]);
            // 做选择
            workloads[i] += job;
            dfs(jobs, workloads, selector - 1);
            // 回溯
            workloads[i] -= job;
        }
    }

    private int max(int[] workloads) {
        return Arrays.stream(workloads).max().getAsInt();
    }
}
