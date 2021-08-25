package com.chehejia.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/19
 */
public class Solution917 {
  public String reverseOnlyLetters(String S) {
    char[] sc = S.toCharArray();
    int left = 0;
    int right = sc.length - 1;
    while (left < right) {
      while (left < right && !Character.isLetter(sc[left])) {
        left++;
      }
      while (right > left && !Character.isLetter(sc[right])) {
        right--;
      }
      char tmp = sc[left];
      sc[left++] = sc[right];
      sc[right--] = tmp;
    }
    return new String(sc);
  }

  public static void main(String[] args) {
    Solution917 solution917 = new Solution917();
    String s = solution917.reverseOnlyLetters("a-bC-dEf-ghIj");
    System.out.println(s);
  }
}
