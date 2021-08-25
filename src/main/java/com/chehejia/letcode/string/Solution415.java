package com.chehejia.letcode.string;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/24
 */
public class Solution415 {

  public String addStrings(String num1, String num2) {
    int add = 0;
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    StringBuffer sb = new StringBuffer();
    while (i >= 0 || j >= 0) {
      int a = i < 0 ? 0 : (num1.charAt(i--) - '0');
      int b = j < 0 ? 0 : (num2.charAt(j--) - '0');
      int sum = a + b + add;
      add = sum / 10;
      sb.append(sum % 10);
    }
    if (add > 0) {
      sb.append(add);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    Solution415 solution415 = new Solution415();
    String result = solution415.addStrings("9","1");
    System.out.println(result);

    String result1 = solution415.addStrings("1000","0");
    System.out.println(result1);

    String result2 = solution415.addStrings("9099","1111111");
    System.out.println(result2);
  }
}
