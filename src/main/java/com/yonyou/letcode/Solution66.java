package com.yonyou.letcode;

import java.util.Arrays;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/21
 */
public class Solution66 {

  /**
   * 加一，只有两种情况，一种是该位数为9，加1后要进位，如果是99，加一后数组长度要加1 第二种情况是非9，加1后最后一位加1即可
   * 第二种情况是小于9，直接加一即可返回
   * @param digits
   * @return
   */
  public int[] plusOne(int[] digits) {
    int i = digits.length - 1;

    while (i >= 0) {
      if (digits[i] < 9) {
        digits[i] = digits[i] + 1;
        return digits;
      } else {
        digits[i] = 0;
        i--;
      }
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
  }

  public static void main(String[] args) {
    Solution66 solution66 = new Solution66();
    int[] digits = new int[]{9,9,9,9};
    int[] result = solution66.plusOne(digits);
    System.out.println(Arrays.toString(result));
  }
}
