package ca.umanitoba.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LC778SwimInRisingWater {
    private static int[][] SHIFTS = {
        { -1, 0 },
        { 0, -1 },
        { 1, 0 },
        { 0, 1 }
    };

    private record Cell(int r, int c, int cost) {}

    public int swimInWater(int[][] grid) {
        var n = grid.length;
        var used = new HashSet<Integer>();
        var heap = new PriorityQueue<Cell>((a, b) -> a.cost - b.cost);
        heap.offer(new Cell(0, 0, grid[0][0]));
        while (!heap.isEmpty()) {
            var cell = heap.poll();
            if (cell.r == n - 1 && cell.c == n - 1) return cell.cost;
            var key = grid[cell.r][cell.c];
            if (used.contains(key)) continue;
            used.add(key);
            for (var shift : SHIFTS) {
                var r = cell.r + shift[0];
                var c = cell.c + shift[1];
                if (r < 0 || c < 0 || r >= n || c >= n || used.contains(grid[r][c])) continue;
                heap.offer(new Cell(r, c, Math.max(cell.cost, grid[r][c])));
            }
        }
        return -1;
    }
}
