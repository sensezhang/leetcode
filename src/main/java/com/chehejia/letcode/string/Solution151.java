package com.chehejia.letcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/17
 */
public class Solution151 {
  public String reverseWords(String s) {
    s = s.trim();
    List<String> words = Arrays.asList(s.split("\\s+"));
    Collections.reverse(words);
    return String.join(" ", words);
  }

  public static void main(String[] args) {
    Solution151 solution151 = new Solution151();
    System.out.println(solution151.reverseWords("the sky is blue"));
    System.out.println(solution151.reverseWords("  hello world!  "));
    System.out.println(solution151.reverseWords("a good   example"));
  }
}
