package com.chehejia.letcode.dp;

import java.util.Arrays;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/9/29 8:53 上午
 **/
public class Solution517 {

    public int findMinMoves(int[] machines) {
        if (machines == null) {
            return -1;
        }
        int len = machines.length;
        int sum = Arrays.stream(machines).sum();
        if (sum % len != 0) {
            return -1;
        }
        int avg = sum / len;
        int ans = 0;
        int curSum = 0;
        for (int i : machines) {
            // 跟平均数差多少，意味着就要变多少次
            i -= avg;
            curSum += i;
            ans = Math.max(ans, Math.max(Math.abs(curSum), i));
        }
        return ans;
    }
}
