package com.chehejia.letcode.dp;

import java.util.Arrays;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/18
 */
public class Solution97 {
  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    int k = s3.length();
    if (m + n != k) {
      return false;
    }
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0 ; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        int p = i + j - 1;
        if (i > 0) {
          dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
        }
        if (j > 0) {
          dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
        }
      }
    }
    for (int i = 0; i <= m; i++) {
      System.out.println(Arrays.toString(dp[i]));
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    Solution97 solution97 =  new Solution97();

    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";
    boolean a = solution97.isInterleave(s1, s2, s3);
    System.out.println(a);
  }
}
