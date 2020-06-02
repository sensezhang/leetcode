package com.yonyou.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/2
 */
public class Solution50 {

  public double myPow(double x, int n) {
    long N = n;
    return n >= 0 ? power(x, n) : 1.0 / power(x, n);
  }

  public double power(double x, long n) {
    if (n == 0) {
      return 1;
    }
    double m = power(x, n / 2);
    return m % 2 == 0 ? m * m : m * m * x;
  }

  public static void main(String[] args) {
    Solution50 solution50 = new Solution50();
    System.out.println(solution50.myPow(2.0, 10));
    System.out.println(solution50.myPow(2.100, 3));
    System.out.println(solution50.myPow(2.00, -2));
  }
}
