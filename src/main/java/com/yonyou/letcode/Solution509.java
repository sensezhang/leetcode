package com.yonyou.letcode;

/**
 * 斐波那契数
 * @Author: zhangwbin
 * @Date: 2020/5/4
 */
public class Solution509 {
  Integer[] cache = null;
  public int fib(int N) {
    if (cache == null) {
      cache = new Integer[N+1];
    }
    if (cache[N]!= null) {
      return cache[N];
    }
    if (N==0) {
      cache[N] = 0;
      return 0;
    }
    if (N==1) {
      cache[N] = 1;
      return 1;
    }
    return fib(N-2) + fib(N-1);
  }

}
