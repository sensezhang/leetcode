package com.yonyou.letcode.array;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/8
 */
public class SolutionM16_11 {

  public int[] divingBoard(int shorter, int longer, int k) {
    int[] board = new int[k + 1];
    for (int i = 0; i <= k; i++) {
      board[i] = shorter * (k - i) + longer * i;
    }
    return board;
  }
}
