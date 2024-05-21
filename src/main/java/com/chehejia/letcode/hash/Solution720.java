package com.chehejia.letcode.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/3/17 3:14 PM
 **/
public class Solution720 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });
        Set<String> set = new HashSet<>();
        set.add("");
        String last = "";
        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i].substring(words[i].length() - 1))) {
                set.add(words[i]);
                last = words[i];
            }
        }
        return last;
    }
}
