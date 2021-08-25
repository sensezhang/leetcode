package com.chehejia.letcode;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/5/29 10:49 下午
 **/
public class Solution5754 {
    public int countGoodSubstrings(String s) {
        int left = 0;
        int right = 0;
        int wind = 0;
        int count = 0;
        char[] cs = s.toCharArray();
        while (left <= right && right < cs.length) {
            if (wind == 0) {
                wind++;

            } else if (wind == 1) {
                if (cs[right] == cs[right - 1]) {
                    left = right;
                } else {
                    wind++;
                }
            } else if (wind == 2) {
                if (cs[right] == cs[right - 1]) {
                    left = right;
                    wind = 1;
                } else if (cs[right] == cs[right - 2]){
                    left++;
                } else {
                    count++;
                    left++;
                }
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution5754 solution5754 = new Solution5754();
        solution5754.countGoodSubstrings("aababcabc");
    }
}
