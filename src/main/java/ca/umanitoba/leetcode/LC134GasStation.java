package ca.umanitoba.leetcode;

public class LC134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            balance += gain;
            tank += gain; // 从 i - 1 到 i 还剩下的油 + 在 i 加的油 - 开到 i - 1 耗的油
            if (tank < 0) { // 没有足够的油开到 i + 1
                tank = 0;
                start = i + 1; // 贪心地忽略 [上一个起点 ~ i] 而选择 i + 1 为新起点 
            }
        }
        return balance < 0 ? -1 : start;
    }
}
