package com.chehejia.letcode;

import java.util.Arrays;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/6/6 11:45 上午
 **/
public class Solution5779 {

    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int m = boxes.length;
        int n = boxes[0].length;
        int k = packages.length;
        int mina = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.sort(boxes[i]);
            if (packages[k - 1] <= boxes[i][boxes[i].length - 1]) {
                int tmp = 0;
                int a = 0;
                for (int j = 0; j < boxes[i].length && a < k;) {
                    if (packages[a] <= boxes[i][j]) {
                        tmp = (tmp + boxes[i][j] - packages[a]) % 1000000007;
                        a++;
                    } else {
                        j++;
                    }
                }
                mina = Math.min(mina, tmp);
            }
        }
        return mina == Integer.MAX_VALUE ? -1 : mina;
    }

    public static void main(String[] args) {
        Solution5779 solution5779 = new Solution5779();
        int a = solution5779.minWastedSpace(new int[]{2,3,5}, new int[][]{{2,8},{4, 8}});
        System.out.println(a);
    }
}
