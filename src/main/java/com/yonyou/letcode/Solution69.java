package com.yonyou.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/11
 */
public class Solution69 {

  /**
   * 二分查找，因为平方根曲线是单调递增，并且有界的
   * @param x
   * @return
   */
  public int mySqrt(int x) {
    long left = 0;
    long right = x / 2 + 1;
    long result = 0;
    while (left <= right) {
      long mid = (left + right) / 2;
      long sq = mid * mid;
      if (sq <= x) {
        result = mid;
        left = mid + 1;
      } else {
        right =  mid - 1;
      }
    }
    return (int)result;
  }

  public static void main(String[] args) {
    Solution69 solution69 = new Solution69();
    System.out.println(solution69.mySqrt(4));
    System.out.println(solution69.mySqrt(8));
  }

}
