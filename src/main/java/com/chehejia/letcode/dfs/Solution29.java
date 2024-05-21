package com.chehejia.letcode.dfs;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/10/12 11:30 上午
 **/
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        int sign = 1;
        long a = dividend, b = divisor;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = div(a, b);
        if (sign > 0) {
            return res > (long)Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
        }
        return (int) -res;
    }

    private long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tb = b;
        while (a >= (tb + tb)) {
            count = count + count;
            tb = tb + tb;
        }
        return count + div(a - tb, b);
    }
}
