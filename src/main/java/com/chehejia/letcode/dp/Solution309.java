package com.chehejia.letcode.dp;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/10
 */
public class Solution309 {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int len = prices.length;
    int[][] dp = new int[3][len];
    // 0 持有股票且最大收益 1 未持有股票且冷冻期 2 未持有股票未冷冻
    dp[0][0] = -prices[0];
    for (int i = 1; i < len; ++i) {
      // 持有股票状态可能由上一天买入或今天买入的，取最大值,今天买入，昨天处理冷冻期
      dp[0][i] = Math.max(dp[0][i - 1], dp[2][i -1] - prices[i]);
      // 未持有股票且冷冻期状态由前一天卖出+最大利润
      dp[1][i] = dp[0][i - 1] + prices[i];
      // 未持有股票且未冷冻期状态由前一天冷冻期或前一天未持有且未冷冻的最大值
      dp[2][i] = Math.max(dp[2][i - 1], dp[1][i - 1]);
    }
    return Math.max(dp[1][len - 1], dp[2][len - 1]);
  }

  /**
   * 优化空间
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int len = prices.length;
    int a = -prices[0];
    int b = 0;
    int c = 0;
    // 0 持有股票且最大收益 1 未持有股票且冷冻期 2 未持有股票未冷冻
    for (int i = 1; i < len; ++i) {
      // 持有股票状态可能由上一天买入或今天买入的，取最大值,今天买入，昨天处理冷冻期
      int tmpa = Math.max(1, c - prices[i]);
      // 未持有股票且冷冻期状态由前一天卖出+最大利润
      int tmpb = a + prices[i];
      // 未持有股票且未冷冻期状态由前一天冷冻期或前一天未持有且未冷冻的最大值
      int tmpc = Math.max(c, b);
      a = tmpa;
      b = tmpb;
      c = tmpc;
    }
    return Math.max(b, c);
  }

  public static void main(String[] args) {
    Solution309 solution309 = new Solution309();
    int x = solution309.maxProfit(new int[]{1,2,3,0,2});
    System.out.println(x);
  }
}
