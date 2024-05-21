package com.chehejia.letcode.binary;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/4/24 9:30 AM
 **/
public class Solution868 {

    public int binaryGap(int n) {
        int lastIndex = -1;
        int curIndex = 0;
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastIndex != -1) {
                    res = Math.max(curIndex - lastIndex, res);
                }
                lastIndex = curIndex;
            }
            n = n >> 1;
            curIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution868 solution868 = new Solution868();
        System.out.println(solution868.binaryGap(22));
    }
}
