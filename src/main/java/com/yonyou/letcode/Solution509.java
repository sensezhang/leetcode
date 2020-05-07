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
    int result = fib(N-2) + fib(N-1);
    cache[N] = result;
    return result;
  }

  public int fib3(int N) {
    int first = 0;
    int second = 1;
    if (N == 0) {
      return first;
    } else if (N == 1) {
      return second;
    } else {
      int result = 0;
      for (int i = 2; i <= N; i ++) {
        result = first + second;
        first = second;
        second = result;
      }
      return result;
    }
  }
  public static void main(String[] args) {

    for (int i = 0; i <= 10; i++) {
      Solution509 solution509 = new Solution509();
      System.out.println(solution509.fib3(i));
    }
  }
}
