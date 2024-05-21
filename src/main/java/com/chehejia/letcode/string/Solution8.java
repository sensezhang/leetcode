package com.chehejia.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/19
 */
public class Solution8 {

  public int myAtoi(String str) {
//    char a = '+';
//    str = str.trim();
//    char[] cs = str.toCharArray();
//    StringBuffer sb = new StringBuffer("0");
//    for (int i = 0; i < cs.length; i++) {
//      if (i == 0 && cs[i]=='-') {
//        a = cs[i];
//      }
//      if (Character.isLetter(cs[i])) {
//        break;
//      }
//      if (Character.isDigit(cs[i])) {
//        sb.append(cs[i]);
//      }
//    }
//    long s = a == '-' ? -Long.parseLong(sb.toString()) : Long.parseLong(sb.toString());
//    return a == '-' ? (s < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)s) : (s > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)s);
    Integer sign = 1;
    char[] cs = str.toCharArray();
    long a = 0L;
    for (int i = 0; i < cs.length; i++) {
      if (a == 0) {
        if (cs[i] == '-') {
          sign = -1;
        } else if (cs[i] >= '0' && cs[i] <= '9') {
          a = a * 10 + (cs[i] - '0');
        } else if (cs[i] == ' ' || cs[i] == '+'){
          continue;
        } else {
          return 0;
        }
      } else if (cs[i] >= '0' && cs[i] <= '9'){
        a = a * 10 + (cs[i] - '0');
      } else if (cs[i] == ' ') {
        continue;
      } else {
        break;
      }
    }
    return sign * a > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (sign * a < Integer.MIN_VALUE ? Integer.MIN_VALUE : sign * a);
  }

  public static void main(String[] args) {
    Solution8 solution8 = new Solution8();
    int a = solution8.myAtoi("213 1343 a 1");
    System.out.println(a);
    int b = solution8.myAtoi("  - 213 1343 a 1");
    System.out.println(b);
  }
}
