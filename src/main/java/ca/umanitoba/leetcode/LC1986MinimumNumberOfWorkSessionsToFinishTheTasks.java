package ca.umanitoba.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1986MinimumNumberOfWorkSessionsToFinishTheTasks {
    private int result = Integer.MAX_VALUE;

    public int minSessions(int[] tasks, int sessionTime) {
        // 排序
        Arrays.sort(tasks);
        int n = tasks.length;
        int[] sessions = new int[n];
        // 从大任务开始
        dfs(tasks, sessions, sessionTime, n - 1, 0);
        return result;
    }

    private void dfs(int[] tasks, int[] sessions, int limit, int selector, int count) {
        // 1. 终止条件
        if (selector < 0) {
            result = Math.min(result, count);
            return;
        }

        // 2. 剪枝：不会比当前全局结果更优的分支
        if (count >= result) return;

        int task = tasks[selector];
        Set<Integer> set = new HashSet<>();
        // 3. 确定选项范围
        // 3.1 已有选项
        for (int i = 0; i < count; i++) {
            // 4. 验证选项
            if (sessions[i] + task > limit) continue;
            // 5. 剪枝：等价的分支
            if (set.contains(sessions[i])) continue;
            set.add(sessions[i]);
            // 做选择
            sessions[i] += task;
            dfs(tasks, sessions, limit, selector - 1, count);
            // 回溯
            sessions[i] -= task;
        }
        // 3.2 新开选项
        // 做选择
        sessions[count] += task;
        dfs(tasks, sessions, limit, selector - 1, count + 1);
        // 回溯
        sessions[count] -= task;
    }
}
