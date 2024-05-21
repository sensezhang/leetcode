package com.chehejia.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划求解三角形的路径和
 * @Author: zhangwbin
 * @Date: 2020/6/25
 */
public class Solution120 {
//  public int minimumTotal(List<List<Integer>> triangle) {
//    int hight = triangle.size();
//    int length = triangle.get(hight - 1).size();
//    int[][] dp = new int[hight][length];
//    for (int i = 0; i < length; i++) {
//      dp[hight - 1][i] = triangle.get(hight - 1).get(i);
//    }
//    for (int i = hight -2; i >= 0; i--) {
//      for (int j = 0; j < triangle.get(i).size(); j++) {
//        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
//      }
//    }
//    return dp[0][0];
//    return minNumTotal(0, 0, triangle);
//
//  }
public int minimumTotal(List<List<Integer>> triangle) {
  int len = triangle.size();
  int[][] dp = new int[len][triangle.get(len - 1).size()];
  dp[0][0] = triangle.get(0).get(0);
  for (int i = 1; i < len; i++) {
    for (int j = 0; j< triangle.get(i).size(); j++) {
      if (j + 1 == triangle.get(i).size()) {
        dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
      } else if (j == 0) {
        dp[i][j] = dp[i - 1][j] + dp[i][j];
      } else {
        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
      }
    }
  }
  int res = Integer.MAX_VALUE;
  for (int i = 0; i < dp[0].length; i++) {
    res = Math.min(dp[len - 1][i], res);
  }
  return res;
}
  public int minNumTotal(int level, int x, List<List<Integer>> triangle) {
    // 结束条件
    if (level== triangle.size() - 1) {
      return triangle.get(triangle.size() - 1).get(x);
    }

    int left = minNumTotal(level + 1, x, triangle);
    int right = minNumTotal(level + 1, x + 1, triangle);

    return Math.min(left, right) + triangle.get(level).get(x);
  }

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{2})));
    triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{3,4})));
    triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{6,5,7})));
    triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{4,1,8,3})));
    Solution120 solution120 = new Solution120();
    int sum = solution120.minimumTotal(triangle);
    System.out.println(sum);
  }
}
