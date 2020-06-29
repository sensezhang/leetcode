package com.yonyou.letcode.dp;

/**
 * 观光点评分，不能用两边夹逼的方式，碰上A[i] == A[j]情况无法处理i和j A[i] + i 取最大值，A[j] - j 最大值是A[i] + i + A[j] - j
 *
 * @Author: zhangwbin
 * @Date: 2020/6/17
 */
public class Solution1014 {

  public int maxScoreSightseeingPair(int[] A) {
    int result = 0;
    if (A == null || A.length == 0) {
      return result;
    }
    int cur = A[0];
    for (int j = 1; j < A.length - 1; j++) {
      result = Math.max(result, cur + A[j] - j);
      cur = Math.max(cur, A[j] + j);
    }
    return result;
  }

  public static void main(String[] args) {
    Solution1014 solution1014 = new Solution1014();
    int[] A = new int[]{8, 1, 5, 2, 6};
    int x = solution1014.maxScoreSightseeingPair(A);
    System.out.println(x);
  }
}
