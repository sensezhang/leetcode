package com.chehejia.letcode.array;

import java.util.Arrays;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/11/2 4:46 下午
 **/
public class Solution6 {

    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        boolean on = false;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            sb[index].append(cs[i]);
            if (!on) {
                if (index == numRows - 1) {
                    on = true;
                    index--;
                } else {
                    index++;
                }
            } else {
                if (index == 0) {
                    on = false;
                    index++;
                } else {
                    index--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(sb[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        String s = solution6.convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
