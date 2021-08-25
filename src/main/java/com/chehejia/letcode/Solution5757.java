package com.chehejia.letcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/5/29 11:16 下午
 **/
public class Solution5757 {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (o1, o2) -> {return o2 - o1;});
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.add(grid[i][j]);
            }
        }
        if (m > 2 && n > 2) {
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int k = Math.min(Math.min(i, j), Math.min(m - 1 - i, n - 1 - j));
                    for (int c = 0; c < k; c++) {
                        queue.add(grid[i + 1 + c][j] + grid[i - 1 - c][j] + grid[i][j + 1 + c] + grid[i][j - 1 - c]);
                    }
                }
            }
        }
        int[] ans = new int[3];
        int i = 0;
        int j = 0;
        while (i < 3 && !queue.isEmpty()) {
            ans[i] = queue.poll();
            if (i > 0 && ans[i] == ans[i - 1]) {
                continue;
            }
            j++;
            i++;
        }
        int[] res = new int[j];
        System.arraycopy(ans, 0, res, 0, j);
        return res;
    }

    public static void main(String[] args) {
        Solution5757 solution5757 = new Solution5757();
        int[] ans = solution5757.getBiggestThree(new int[][]{{20,17,9,13,5,2,9,1,5},{14,9,9,9,16,18,3,4,12},{18,15,10,20,19,20,15,12,11},{19,16,19,18,8,13,15,14,11},{4,19,5,2,19,17,7,2,2}});
        System.out.println(Arrays.toString(ans));
    }
}
