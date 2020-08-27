package com.yonyou.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/9
 */
public class Solution5483 {

  public String makeGood(String s) {
    char[] cs = s.toCharArray();
    int len = cs.length;
    if (len == 1) {
      return s;
    } else {
      for (int i = 0; i < len - 1;) {
        if ('a' <= cs[i] && 'z' >= cs[i] && 'A' <= cs[i + 1] && 'Z' >= cs[i + 1]) {
          cs[i] = ' ';
          cs[i + 1] = ' ';
          i += 2;
        } else if ('A' <= cs[i] && 'Z' >= cs[i] && 'a' <= cs[i + 1] && 'z' >= cs[i + 1]) {
          cs[i] = ' ';
          cs[i + 1] = ' ';
          i += 2;
        } else {
          i++;
        }
      }
    }
    return new String(cs).replaceAll(" ", "");
  }
}
