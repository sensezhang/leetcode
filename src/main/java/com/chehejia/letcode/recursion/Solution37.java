package com.chehejia.letcode.recursion;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/1
 */
public class Solution37 {

  private static final int len = 9;
  boolean[][] row = new boolean[len][len];
  boolean[][] col = new boolean[len][len];
  boolean[][] boxes = new boolean[len][len];

  public void solveSudoku(char[][] board) {
    // 初始化数组
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (board[i][j] != '.') {
          int value = board[i][j] - '1';
          int boxY = (i / 3) * 3 + j / 3;
          row[i][value] = true;
          col[j][value] = true;
          boxes[boxY][value] = true;
        }
      }
    }
    // 递归设置单元格的值
    dfs(board, 0, 0);

  }

  // 一行一行填充数据
  private boolean dfs(char[][] board, int i, int j) {
    if (j == len) {
      // 如果行满了，进入下一行，初始化j = 0
      i++;
      j = 0;
      // 如果列也满了，说明所有格子都填充完了
      if (i == len) {
        return true;
      }
    }
    // 如果格子是空的，就尝试填充从1-9的数字
    if (board[i][j] == '.') {
      for (int k = 0; k < 9; k++) {
        char a = (char) ('1' + k);
        if (isValidSudoku(a, i, j)) {
          // 如果可以放进去，就设置行列和3*3方格，填充数独的格子
          trySet(board, i, j, a);
          boolean valid = dfs(board, i, j + 1);
          if (valid) {
            return true;
          }
          // 回溯，修改初始状态
          remove(board, i, j, a);
        }
      }
      return false;
    }
    return dfs(board, i, j + 1);
  }


  private void trySet(char[][] board, int i, int j, char o) {
    int value = o - '1';
    int boxY = (i / 3) * 3 + j / 3;
    row[i][value] = true;
    col[j][value] = true;
    boxes[boxY][value] = true;
    board[i][j] = o;
  }

  private void remove(char[][] board, int i, int j, char o) {
    int value = o - '1';
    int boxY = (i / 3) * 3 + j / 3;
    row[i][value] = false;
    col[j][value] = false;
    boxes[boxY][value] = false;
    board[i][j] = '.';
  }

  /**
   * 查看该数字放在这个位置上是否合适
   *
   * @param o 数字 1- 9
   * @param i 纵坐标
   * @param j 横坐标
   * @return
   */
  public boolean isValidSudoku(char o, int i, int j) {
    int value = o - '1';
    int boxY = (i / 3) * 3 + j / 3;
    if (!row[i][value] && !col[j][value] && !boxes[boxY][value]) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Solution37 solution37 = new Solution37();
    char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},{
    '6', '.', '.', '1', '9', '5', '.', '.', '.'},{'.', '9', '8', '.', '.', '.', '.', '6', '.'},{
    '8', '.', '.', '.', '6', '.', '.', '.', '3'},{'4', '.', '.', '8', '.', '3', '.', '.', '1'},{
    '7', '.', '.', '.', '2', '.', '.', '.', '6'},{'.', '6', '.', '.', '.', '.', '2', '8', '.'},{
    '.', '.', '.', '4', '1', '9', '.', '.', '5'},{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    solution37.solveSudoku(board);

    for (int i = 0; i < len; i++) {
      String s = new String(board[i]);
      System.out.println(s);
    }
  }
}
