package com.yonyou.letcode;

/**
 * 买卖股票最佳时机，T+0
 * @Author: zhangwbin
 * @Date: 2020/6/12
 */
public class Solution122 {
  public int maxProfit(int[] prices) {
    int count = 0;
    if (prices == null) {
      return count;
    }
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        count += prices[i + 1] - prices[i];
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] prices = new int[]{7,1,5,3,6,4};
    Solution122 solution122 = new Solution122();
    int count = solution122.maxProfit(prices);
    System.out.println(count);
  }
}
