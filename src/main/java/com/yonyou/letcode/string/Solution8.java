package com.yonyou.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/19
 */
public class Solution8 {

  public int myAtoi(String str) {
    char a = '+';
    str = str.trim();
    char[] cs = str.toCharArray();
    StringBuffer sb = new StringBuffer("0");
    for (int i = 0; i < cs.length; i++) {
      if (i == 0 && cs[i]=='-') {
        a = cs[i];
      }
      if (Character.isLetter(cs[i])) {
        break;
      }
      if (Character.isDigit(cs[i])) {
        sb.append(cs[i]);
      }
    }
    long s = a == '-' ? -Long.parseLong(sb.toString()) : Long.parseLong(sb.toString());
    return a == '-' ? (s < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)s) : (s > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)s);
  }

  public static void main(String[] args) {
    Solution8 solution8 = new Solution8();
    int a = solution8.myAtoi("213 1343 a 1");
    System.out.println(a);
    int b = solution8.myAtoi("  - 213 1343 a 1");
    System.out.println(b);
  }
}
