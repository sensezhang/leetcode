package com.chehejia.letcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/4/27 9:27 AM
 **/
public class Solution417 {
    int m = 0;
    int n = 0;
    int[] xs = new int[]{0, 0, 1, -1};
    int[] ys = new int[]{1, -1, 0, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 能够同时触达左上边界 x = 0, y = 0 及右下边界 x = n - 1, y = m - 1
        m = heights.length;
        n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(heights, j, i)) {
                    List<Integer> lists = new ArrayList<>();
                    lists.add(i);
                    lists.add(j);
                    res.add(lists);
                }
            }
        }
        return res;
    }

    public boolean dfs(int[][] heights, int x, int y) {
        if (checkAtlantic(heights, x, y) && checkPacific(heights, x, y)) {
            return true;
        }
        int tmpx = x;
        int tmpy = y;
        for (int i = 0; i < 4; i++) {
            tmpx = x+xs[i];
            tmpy = y+ys[i];
            if (tmpx >= 0 && tmpx < n && tmpy >= 0 && tmpy < m && heights[tmpy][tmpx] <= heights[y][x]) {
                return dfs(heights, tmpx, tmpy);
            }
        }
        return false;
    }

    // 判断当前坐标是否可以触达左上边界
    public boolean checkPacific(int[][] heights, int x, int y) {
        int cur = heights[y][x];
        boolean ans = true;
        for (int i = y - 1; i >= 0; i--) {
            if (cur < heights[i][x]) {
                ans = false;
                break;
            }
            cur = heights[i][x];
        }
        if (ans) {
            return ans;
        }
        cur = heights[y][x];
        for (int j = x - 1; j >=0; j--) {
            if (cur < heights[y][j]) {
                return false;
            }
            cur = heights[y][j];
        }
        return true;
    }

    // 判断当前坐标是否可以触达右下边界
    public boolean checkAtlantic(int[][] heights, int x, int y) {
        int cur = heights[y][x];
        boolean ans = true;
        for (int i = y + 1; i < m; i++) {
            if (cur < heights[i][x]) {
                ans = false;
                break;
            }
            cur = heights[i][x];
        }
        if (ans) {
            return ans;
        }
        cur = heights[y][x];
        for (int j = x + 1; j < n; j++) {
            if (cur < heights[y][j]) {
                return false;
            }
            cur = heights[y][j];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution417 solution417 = new Solution417();
        solution417.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
    }
}
