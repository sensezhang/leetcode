package com.yonyou.letcode;

import java.util.regex.Pattern;

/**
 * 是否回文串
 *
 * @Author: zhangwbin
 * @Date: 2020/5/3
 */
public class Solution125 {

  public boolean isPalindrome(String s) {
/*    // 去掉空格以外的所有字符
    s = removeOther(s);
    // 反转字符串
    String s2 = reverseStr(s);
    // 对比
    return s.equalsIgnoreCase(s2);*/

    if (s.isEmpty()) {
      return true;
    }
    int head = 0;
    int end = s.length() - 1;
    char[] str = s.toUpperCase().toCharArray();
    while (head < end) {
      if (!Character.isLetterOrDigit(str[head])) {
        head ++;
        continue;
      }
      if (!Character.isLetterOrDigit(str[end])) {
        end --;
        continue;
      }
      if (str[head] != str[end]) {
        return false;
      }
      head ++;
      end --;
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
    String s = "A man, a plan, a canal: Panama";
    Solution125 solution125 = new Solution125();
    System.out.println(solution125.isPalindrome(s));
  }
}
