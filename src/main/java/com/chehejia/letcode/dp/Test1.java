package com.chehejia.letcode.dp;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/25
 */
public class Test1 {
  public int numDecodings(String s) {
    if (s == null) {
      return 0;
    }
    int len = s.length();
    int dp[] = new int[len + 1];
    dp[0] = 1;
    char[] arr = s.toCharArray();
    for (int i = 0; i < len; i++) {
      char a = arr[i];
      if (a == '0') {
        dp[i] = 0;
      }
      if (i > 0 && (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] >= 0 && arr[i] <= '6'))) {
        dp[i + 1] = dp[i - 1] + dp[i];
      } else {
        dp[i + 1] = dp[i];
      }
    }
    return dp[len];
  }

  public static void main(String[] args) {
    Test1 test1 = new Test1();
    System.out.println(test1.numDecodings("1200"));
  }
}
