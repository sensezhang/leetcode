package com.chehejia.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/14
 */
public class Solution5 {
  public String longestPalindrome(String s) {
    char[] arrs = s.toCharArray();
    int maxLength = Integer.MIN_VALUE;
    String longestPalindStr = "";
    for (int i = 0; i < arrs.length; i++) {
      // 中间两个数相等，往外扩散
      if (i + 1 < arrs.length && arrs[i] == arrs[i + 1]) {
        int n = 1;
        while (i - n >= 0 && i + n < arrs.length && arrs[i - n] == arrs[i + n]) {
          n = n + 1;
        }
        if (n * 2 > maxLength) {
          maxLength = n * 2;
          char[] a = new char[n * 2];
          System.arraycopy(arrs, i - n + 1, a, 0, n * 2);
          longestPalindStr = new String(a);
        }
      }
      // 中间一个数不相等，往外扩散
      if (i - 1 >= 0 && i + 1 < arrs.length && arrs[i - 1] == arrs[i + 1]) {
        int n = 1;
        while (i - n >= 0 && i + n < arrs.length && arrs[i - n] == arrs[i + n]) {
          n = n + 1;
        }
        if (n * 2 - 1 > maxLength) {
          maxLength = n * 2 - 1;
          char[] a = new char[n * 2 - 1];
          System.arraycopy(arrs, i - n + 1, a, 0, n * 2 - 1);
          longestPalindStr = new String(a);
        }
      }
    }
    return longestPalindStr;
  }

  public static void main(String[] args) {
    Solution5 solution5 = new Solution5();
    String s = solution5.longestPalindrome("ccc");
    System.out.println(s);
  }
}
