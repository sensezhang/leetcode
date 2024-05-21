package com.chehejia.letcode.array;

import java.util.Arrays;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/10 9:52 下午
 **/
public class Solution748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] wordCount = new int[26];
        int sum = 0;
        for (char a : licensePlate.toCharArray()) {
            if (Character.isLetter(a)) {
                wordCount[Character.toLowerCase(a) - 'a']++;
                sum++;
            }
        }
        int ans = licensePlate.length();
        String res = licensePlate;

        for (String word : words) {
            int[] tmp = Arrays.copyOf(wordCount, 26);
            int _sum = sum;
            for (char a : word.toCharArray()) {
                if (tmp[Character.toLowerCase(a) - 'a'] > 0) {
                    tmp[Character.toLowerCase(a) - 'a']--;
                    _sum++;
                }
                if (sum == _sum) {
                    return word;
                }
            }
        }
        return "傻逼";
    }
}
