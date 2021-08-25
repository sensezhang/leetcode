package com.chehejia.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/28
 */
public class Solution1455 {

  public int isPrefixOfWord(String sentence, String searchWord) {
    String[] strs = sentence.split(" ");
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].startsWith(searchWord)) {
        return i + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    String sentence = "i love eating burger";
    String searchWord = "burg";
    Solution1455 solution1455 = new Solution1455();
    System.out.println(solution1455.isPrefixOfWord(sentence, searchWord));
  }
}
