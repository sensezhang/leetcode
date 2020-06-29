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
}
