package com.chehejia.letcode.recursion;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/8
 */
public class Solution200 {
  int[] xround = new int[]{1,-1,0,0};
  int[] yround = new int[]{0,0,1,-1};
  public int numIslands(char[][] grid) {
    int count = 0;
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[0].length; x++) {
        if (grid[y][x] == '1') {
          count++;
          // 将与1相连的所有横向和纵向的陆地设置为0
          dfs(grid, y, x);
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int y, int x) {
    if (y < 0 || x < 0 || y >= grid.length || x >= grid[0].length || grid[y][x] == '0') {
      return;
    }
    grid[y][x] = '0';
    for (int i = 0; i < 4; i++) {
      dfs(grid, y + yround[i], x + xround[i]);
    }
  }


  public static void main(String[] args) {
    Solution200 solution200 = new Solution200();
    char[][] grid = new char[][]{{'1','0','1','1','0','1','1'}};
    int count = solution200.numIslands(grid);
    System.out.println(count);
  }
}
