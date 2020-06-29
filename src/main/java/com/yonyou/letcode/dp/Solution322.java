package com.yonyou.letcode.dp;

import java.util.Arrays;

/**
 * 零钱兑换问题
 * @Author: zhangwbin
 * @Date: 2020/6/26
 */
public class Solution322 {
  int min = Integer.MAX_VALUE;
  public int coinChange(int[] coins, int amount) {
//    Deque<Integer> stack = new LinkedList<>();
//    stack.add(amount);
//    int count = 0;
//    while (!stack.isEmpty()) {
//      int size = stack.size();
//      for (int m = 0; m < size; m++) {
//        int lAmount = stack.pop();
//        if (lAmount == 0) {
//          return count;
//        } else if (lAmount < 0) {
//          break;
//        }
//        for (int i = 0; i < coins.length; i++) {
//          int re = lAmount - coins[i];
//          if (re >= 0) {
//            stack.add(lAmount - coins[i]);
//          }
//        }
//      }
//      count++;
//    }
//    return -1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i >= coins[j]) {
          dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }


  public static void main(String[] args) {
    Solution322 solution322 = new Solution322();
    int count = solution322.coinChange(new int[]{2,5, 10, 1}, 27);
    System.out.println(count);
  }
}
