package com.chehejia.letcode.array;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/13 8:58 上午
 **/
public class Solution807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] maxm = new int[len];
        int[] maxn = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxm[j] = Math.max(maxm[j], grid[i][j]);
                maxn[i] = Math.max(maxn[i], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = ans + Math.min(maxm[j], maxn[i]) - grid[i][j];
            }
        }
        return ans;
    }
}
