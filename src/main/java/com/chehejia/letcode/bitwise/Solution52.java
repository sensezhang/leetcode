package com.chehejia.letcode.bitwise;


/**
 * @Author: zhangwbin
 * @Date: 2020/7/6
 */
public class Solution52 {
  private int count;
  private int size;
  public int totalNQueens(int n) {
    count = 0;
    size = (1 << n) - 1;
    dfs(0, 0, 0);
    return count;
  }

  private void dfs(int pie, int na, int row) {
    if (row == size) {
      count++;
      return;
    }
    System.out.println("pie: " + Integer.toBinaryString(pie) + "; na: " + Integer.toBinaryString(na) + "; row: " + Integer.toBinaryString(row));
    System.out.println(Integer.toBinaryString(pie | na | row));
    System.out.println(Integer.toBinaryString(size & (~(pie | na | row))));
    // 获取可放皇后的位置标记1， 11111111
    int pos = size & (~(pie | na | row));
    while (pos != 0) {
      // p为取最低为的1，即从低位1开始计算
      int p = pos & (-pos);
      // 在p位置上放入皇后，即p位置置为0
      pos = pos - p;
      // 进入下一层递归
      dfs((pie | p) >> 1, (na | p) << 1, row | p);
    }
  }

  public static void main(String[] args) {
    Solution52 solution52 = new Solution52();
    int count = solution52.totalNQueens(4);
    System.out.println(count);
  }
}
