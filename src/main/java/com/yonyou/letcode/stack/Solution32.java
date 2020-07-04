package com.yonyou.letcode.stack;

import java.util.Stack;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/27
 */
public class Solution32 {

  public int longestValidParentheses(String s) {
    int maxCount = 0;
    Stack<Character> stack = new Stack<>();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        if (stack.isEmpty()) {
          count = 0;
        }
        stack.push(s.charAt(i));
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
          count += 2;
        }
      }
      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }

  public int longestValidParentheses2(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int leftCount = 0;
    int i = 0;
    int[] dp = new int[s.length()];
    while (i < s.length()) {
      if (s.charAt(i) == '(') {
        leftCount++;
      } else {
        if (leftCount >= 1) {
          dp[i] = dp[i - 1] + 2;
          if (i > dp[i]) {
            dp[i] = dp[i - dp[i]] + dp[i];
          }
          leftCount--;
        }
      }
      i++;
    }
    return dp[s.length() -1];
  }

  public static void main(String[] args) {
    Solution32 solution32 = new Solution32();
    int count = solution32.longestValidParentheses2(")()())");
    System.out.println(count);
  }
}
