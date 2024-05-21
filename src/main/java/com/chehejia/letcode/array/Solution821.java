package com.chehejia.letcode.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/4/22 10:53 PM
 **/
public class Solution821 {

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] res = new int[len];
        Arrays.fill(res, len);
        char[] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (cs[i] == c) {
                res[i] = 0;
                int k = 1;
                while (!stack.isEmpty()) {
                    int index = stack.pop();
                    res[index] = Math.min(k++, res[index]);
                }
            } else {
                stack.push(i);
                if (i > 0) {
                    res[i] = res[i - 1] + 1;
                }
            }
        }
        return res;
    }
}
