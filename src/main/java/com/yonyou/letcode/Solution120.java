package com.yonyou.letcode;

import java.util.List;

/**
 * 动态规划求解三角形的路径和
 * @Author: zhangwbin
 * @Date: 2020/6/25
 */
public class Solution120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int hight = triangle.size();
    int length = triangle.get(hight - 1).size();
    int[][] dp = new int[hight][length];
    for (int i = 0; i < length; i++) {
      dp[hight - 1][i] = triangle.get(hight - 1).get(i);
    }
    for (int i = hight -2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
      }
    }
    return dp[0][0];
  }

}
