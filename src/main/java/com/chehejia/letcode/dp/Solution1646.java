package com.chehejia.letcode.dp;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/8/23 10:03 上午
 **/
public class Solution1646 {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int ans = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i/2] + ((i % 2) * dp[i / 2 + 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
