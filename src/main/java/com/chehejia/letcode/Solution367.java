package com.chehejia.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/11
 */
public class Solution367 {

  /**
   * 二分查找
   * @param num
   * @return
   */
  public boolean isPerfectSquare(int num) {
    long left = 0;
    long right = num;
    while (left <= right) {
      long mid = (left + right) / 2;
      long result = mid * mid;
      if (result == num) {
        return true;
      } else if (result < num) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution367 solution367 = new Solution367();
    boolean result = solution367.isPerfectSquare(2147483647);
    System.out.println(result);
  }
}
