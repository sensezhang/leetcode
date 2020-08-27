package com.yonyou.letcode.stack;

import java.util.Stack;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/24
 */
public class Solution844 {
  public boolean backspaceCompare(String S, String T) {
    Stack<Character> stacks = new Stack<>();
    Stack<Character> stackt = new Stack<>();

    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '#') {
        if (!stacks.isEmpty()) {
          stacks.pop();
        }
      } else {
        stacks.push(S.charAt(i));
      }
    }
    for (int i = 0; i < T.length(); i++) {
      if (T.charAt(i) == '#') {
        if (!stackt.isEmpty()) {
          stackt.pop();
        }
      } else {
        stackt.push(T.charAt(i));
      }
    }
    return stacks.equals(stackt);
  }
}
