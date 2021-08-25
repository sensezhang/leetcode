package com.chehejia.letcode.recursion;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/11
 */
public class Solution52 {

  int count = 0;
  int size;
  public int totalNQueens(int n) {
    size = (1 << n) - 1;
    dfs(0, 0, 0);
    return count;
  }

  private void dfs(int pie, int na, int row) {
    if (row == size) {
      count++;
      return;
    }
    // 获取可放皇后的位置标记为1,11111111
    int pos = size &(~(pie | na | row));
    while (pos != 0) {
      int p = pos & (-pos);
      pos = pos - p;
      //进入下一层递归
      dfs((pie | p) >> 1, (na | p) << 1, (row | p));
    }
  }

  public static void main(String[] args) {
    Solution52 solution52 = new Solution52();
    int count = solution52.totalNQueens(4);
    System.out.println(count);
  }
}
