package com.chehejia.letcode;

import java.util.regex.Pattern;

/**
 * 是否回文串
 *
 * @Author: zhangwbin
 * @Date: 2020/5/3
 */
public class Solution125 {

  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }

  private String reverseStr(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  private String removeOther(String s) {
    String pattern = "[^0-9a-zA-Z]";
    String s1 = Pattern.compile(pattern).matcher(s).replaceAll("");
    return s1;
  }

  public static void main(String[] args) {
    String s = "race a car";
    Solution125 solution125 = new Solution125();
    System.out.println(solution125.isPalindrome(s));
  }
}
