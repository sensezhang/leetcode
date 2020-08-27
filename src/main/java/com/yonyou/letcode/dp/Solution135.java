package com.yonyou.letcode.dp;

import java.util.Arrays;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/13
 */
public class Solution135 {

  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    int[] dp = new int[ratings.length];
    int dpSum = 0;
    Arrays.fill(dp, 1);
    for (int i = 0; i < ratings.length; i++) {
      if (i - 1 >= 0 && ratings[i - 1] < ratings[i]) {
        dp[i] = Math.max(dp[i], dp[i -1] + 1);
      }
      if (i + 1 < ratings.length && ratings[i + 1] < ratings[i]) {
        dp[i] = Math.max(dp[i], dp[i + 1] + 1);
      }
    }
    for (int i = ratings.length - 1; i >= 0; i--) {
      if (i - 1 >= 0 && ratings[i - 1] < ratings[i]) {
        dp[i] = Math.max(dp[i], dp[i -1] + 1);
      }
      if (i + 1 < ratings.length && ratings[i + 1] < ratings[i]) {
        dp[i] = Math.max(dp[i], dp[i + 1] + 1);
      }
      dpSum += dp[i];
    }
    return dpSum;
  }

  public static void main(String[] args) {
    Solution135 solution135 = new Solution135();
    int a = solution135.candy(new int[]{1,2,87,87,87,2,1});
    System.out.println(a);
  }
}
