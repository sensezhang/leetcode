package com.chehejia.letcode.dp;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/27
 */
public class Solution392 {
  public boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) {
      return true;
    }
    if (t == null || t.length() == 0) {
      return false;
    }
    boolean[][] dp = new boolean[t.length() + 1][s.length() + 1];
    for (int i = 0; i <= t.length(); i++) {
      dp[i][0] = true;
    }

    for (int i = 0; i < t.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == t.charAt(i)) {
          dp[i + 1][j + 1] = dp[i][j];
          if (dp[i + 1][j + 1] && j == s.length() - 1) {
            return dp[i + 1][j + 1];
          }
        } else {
          dp[i + 1][j + 1] = dp[i + 1][j];
        }
      }
    }
    return dp[t.length()][s.length()];
  }

  public static void main(String[] args) {
    Solution392 soltion392 = new Solution392();
    System.out.println(soltion392.isSubsequence("twn","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn"));
  }
}
