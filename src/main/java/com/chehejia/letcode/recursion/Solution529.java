package com.chehejia.letcode.recursion;

import java.util.Arrays;

/**
 * 扫雷游戏
 * @Author: zhangwbin
 * @Date: 2020/6/8
 */
public class Solution529 {

  int[] xround = new int[]{-1,-1,-1,0,0,1,1,1};
  int[] yround = new int[]{1,0,-1,1,-1,1,0,-1};
  public char[][] updateBoard(char[][] board, int[] click) {
    dfs(board, click[0], click[1]);
    return board;
  }

  private void dfs(char[][] board, int y, int x) {
    // terminator
    if (y < 0 || x < 0 || y >= board.length || x >= board[0].length) {
      return;
    }

    // process
    if (board[y][x] == 'E') {
      int count = checkMine(board, y, x);
      if (count == 0) {
        board[y][x] = 'B';
        for (int i = 0; i < 8; i++) {
          dfs(board, y + yround[i], x+xround[i]);
        }
      } else {
        board[y][x] = (char)(count + '0');
      }
    } else if (board[y][x] == 'M') {
      board[y][x] = 'X';
    }
  }

  private int checkMine(char[][] board, int y, int x) {
    int count = 0;
    for (int i = 0; i < 8; i++) {
      int newx = x + xround[i];
      int newy = y + yround[i];
      if (newx < 0 || newy < 0 || newx >= board[0].length || newy >= board.length) {
        continue;
      }
      if (board[newy][newx] == 'M') {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Solution529 solution529 = new Solution529();
    char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};
    int[] click = new int[]{3, 0};
    char[][] result = solution529.updateBoard(board, click);
    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }

}
