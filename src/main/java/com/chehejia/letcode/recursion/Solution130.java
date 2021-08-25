package com.chehejia.letcode.recursion;

import java.util.Arrays;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/1
 */
public class Solution130 {

  int[] xround = new int[]{1, -1, 0, 0};
  int[] yround = new int[]{0, 0, 1, -1};
  int row;
  int col;

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    row = board.length;
    col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        // 如果碰到边界，把所有跟O相关联的O都设置为'#'
        if (((i == 0 || i == row - 1)|| (j == 0 || j == col - 1)) && board[i][j] == 'O') {
          dfs(board, i, j);
        }
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j]=='O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == '#') {
          board[i][j] = 'O';
        }

      }
    }
  }

  private void dfs(char[][] board, int i, int j) {
    board[i][j] = '#';
    for (int k = 0; k < 4; k++) {
      int newi = i + xround[k];
      int newj = j + yround[k];
      if (newi >= 0 && newi < row && newj >= 0 && newj < col && board[newi][newj] == 'O') {
        dfs(board, newi, newj);
      }
    }
  }


  public static void main(String[] args) {
    Solution130 solution130 = new Solution130();
    char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
    solution130.solve(board);
    for (int i = 0; i < board.length; i++) {
      System.out.println(Arrays.toString(board[i]));
    }
  }
}
