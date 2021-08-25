package com.chehejia.letcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/26
 */
public class Solution20 {

  public boolean isValid(String s) {
    if (s == null || "".equals(s)) {
      return true;
    }
    Map<Character, Character> map = new HashMap<>();
    map.put(')','(');
    map.put(']','[');
    map.put('}','{');
    Stack<Character> stack = new Stack();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (!map.containsKey(c)) {
        stack.push(c);
      } else {
        char a = stack.empty()? '#':stack.pop();
        if (a != map.get(c)) {
          return false;
        }
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {
    String s = "()[]{}";
    Solution20 solution20 = new Solution20();
    System.out.println(solution20.isValid(s));
  }
}
