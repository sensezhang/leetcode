package com.chehejia.letcode.dp;

/**
 * 爬楼梯
 * @Author: zhangwbin
 * @Date: 2020/6/25
 */
public class Solution70 {

  public int climbStairs(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int n_1 = 1;
    int n_2 = 2;
    int result = n_2;
    for (int i = 2; i < n; i++) {
      result =n_1 + n_2;
      n_1 = n_2;
      n_2 = result;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution70 solution70 = new Solution70();
    int x = solution70.climbStairs(3);
    System.out.println(x);
  }
}
