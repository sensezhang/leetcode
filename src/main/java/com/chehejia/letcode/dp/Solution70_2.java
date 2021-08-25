package com.chehejia.letcode.dp;

/**
 * 爬楼梯变种2 1，2，3，相邻两步不能相同
 * @Author: zhangwbin
 * @Date: 2020/6/25
 */
public class Solution70_2 {
  public int climbStairs(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 1;
    }
    int[][] dp = new int[n][3];
    dp[0][0] = 1; // 第一层走一步
    dp[0][1] = 0;
    dp[0][2] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;// 第二层走两步
    dp[1][2] = 0;
    dp[2][0] = dp[1][1] + dp[1][2];// 2, 1
    dp[2][1] = dp[1][0] + dp[1][2];// 1, 2
    dp[2][2] = dp[1][0] + dp[1][1] + 1; // 0, 3
    for (int i = 3; i < n; i++) {
      dp[i][0] = dp[i - 1][1] + dp[i - 1][2];
      dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
      dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
    }
    return dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2];
  }

  public static void main(String[] args) {
    Solution70_2 solution70_2 = new Solution70_2();
    for (int i = 0; i < 10; i++) {
      System.out.println(solution70_2.climbStairs(i));
    }

  }
}
