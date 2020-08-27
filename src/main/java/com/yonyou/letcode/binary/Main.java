package com.yonyou.letcode.binary;

import java.util.Scanner;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/26
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] dp = new int[n][n];
    int[][] board = new int[n][n];
    int mumi = 0;
    int mumj = 0;
    int babyi = 0;
    int babyj = 0;
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        int cell = sc.nextInt();
        board[row][col] = cell;
        if (cell == -3) {
          mumi = row;
          mumj = col;
        }
        if (cell == -2){
          babyi = row;
          babyj = col;
        }
      }
    }
    dp[babyi][babyj] = 0;
    if (babyi > mumi && babyj > mumj) {
      for (int i = babyi; i >=mumi; i--) {
        for (int j = babyj; j >= mumj; j--) {
          if (i != babyi || j != babyj) {

            if (board[i][j] == -1){
              dp[i][j] = 0;
            } else {
              if (i == babyi) {
                dp[i][j] = dp[i][j + 1] + board[i][j];
              } else if (j == babyj) {
                dp[i][j] = dp[i + 1][j] + board[i][j];
              } else {
                dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]) + board[i][j];
              }
            }
          }
        }
      }
      System.out.println(Math.max(dp[mumi + 1][mumj], dp[mumi][mumj + 1]));
    } else if (babyi < mumi && babyj < mumj) {
      for (int i = babyi; i <=mumi; i++) {
        for (int j = babyj; j <= mumj; j++) {
          if (i != babyi || j != babyj) {

            if (board[i][j] == -1){
              dp[i][j] = 0;
            } else {
              if (i == babyi) {
                dp[i][j] = dp[i][j - 1] + board[i][j];
              } else if (j == babyj) {
                dp[i][j] = dp[i - 1][j] + board[i][j];
              } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + board[i][j];
              }
            }
          }
        }
      }
      System.out.println(Math.max(dp[mumi - 1][mumj], dp[mumi][mumj - 1]));
    } else if (babyi > mumi && babyj < mumj) {
      for (int i = babyi; i >=mumi; i--) {
        for (int j = babyj; j <= mumj; j++) {
          if (i != babyi || j != babyj) {

            if (board[i][j] == -1){
              dp[i][j] = 0;
            } else {
              if (i == babyi) {
                dp[i][j] = dp[i][j - 1] + board[i][j];
              } else if (j == babyj) {
                dp[i][j] = dp[i + 1][j] + board[i][j];
              } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]) + board[i][j];
              }
            }
          }
        }
      }
      System.out.println(Math.max(dp[mumi + 1][mumj], dp[mumi][mumj - 1]));
    } else {
      // babyi <= mumi && babyj >= mumj
      for (int i = babyi; i <=mumi; i++) {
        for (int j = babyj; j >= mumj; j--) {
          if (i != babyi || j != babyj) {

            if (board[i][j] == -1){
              dp[i][j] = 0;
            } else {
              if (i == babyi) {
                dp[i][j] = dp[i][j + 1] + board[i][j];
              } else if (j == babyj) {
                dp[i][j] = dp[i - 1][j] + board[i][j];
              } else {
                dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]) + board[i][j];
              }
            }
          }
        }
      }
      System.out.println(Math.max(dp[mumi - 1][mumj], dp[mumi][mumj + 1]));
    }

  }
}
