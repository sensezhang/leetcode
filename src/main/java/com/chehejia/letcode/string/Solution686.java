package com.chehejia.letcode.string;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/23 7:24 下午
 **/
public class Solution686 {

    public int repeatedStringMatch(String a, String b) {
        // 如果b里有a里没有，直接返回-1
        boolean[] m = new boolean[26];
        for (char c : a.toCharArray()) {
            int index = c - 'a';
            m[index] = true;
        }
        for (char c : b.toCharArray()) {
            int index = c - 'a';
            if (!m[index]) {
                return -1;
            }
        }
        int count = b.length() / a.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(a);
        }
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return count + i;
            } else {
                sb.append(a);
            }
        }
        return -1;
    }
}
