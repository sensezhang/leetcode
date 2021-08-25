package com.chehejia.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/13
 */
public class Solution43 {
  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int add = 0;
    StringBuilder sum = new StringBuilder();
    for (int i = len2 - 1; i >= 0; i--) {
      int n2 = num2.charAt(i) - '0';
      StringBuilder one = new StringBuilder();
      for (int k = i; k < len2 - 1; k++) {
        one.append(0);
      }
      for (int j = len1 - 1; j >= 0; j--) {
        int n1 = num1.charAt(j) - '0';
        int mulitiply = n2 * n1 + add;
        add = mulitiply / 10;
        one.append(mulitiply % 10);
      }
      if (add != 0) {
        one.append(add % 10);
        add = add / 10;
      }
      sum = add(sum, one);
    }
    return sum.reverse().toString();
  }
  private StringBuilder add(StringBuilder sum, StringBuilder one) {
    StringBuilder sb = new StringBuilder();
    int len1 = sum.length();
    int len2 = one.length();
    int add = 0;
    if (len1 == 0) {
      return one;
    }
    int i = 0, j = 0;
    while (i < len1 || j < len2 || add != 0) {
      int a = (i > len1 - 1 ? 0 : (sum.charAt(i) - '0')) + (j > len2 - 1 ? 0 : (one.charAt(j) - '0')) + add;
      sb.append(a % 10);
      add = a / 10;
      i++;
      j++;
    }
    return sb;
  }

  public static void main(String[] args) {
    Solution43 solution43 = new Solution43();
//    StringBuilder sb = solution43.add(new StringBuilder("9999"), new StringBuilder("1"));
    String s = solution43.multiply("9", "99");
    System.out.println(s);
  }

}
