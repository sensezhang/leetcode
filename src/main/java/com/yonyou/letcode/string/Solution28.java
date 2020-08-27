package com.yonyou.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/15
 */
public class Solution28 {
  public int strStr(String haystack, String needle) {
    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() < haystack.length()) {
        String str = haystack.substring(i, i + needle.length());
        if (str.equals(needle)) {
          return i;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution28 solution28 = new Solution28();
    System.out.println(solution28.strStr("hello","ll"));
    System.out.println(solution28.strStr("aaaaa","bba"));
  }
}
