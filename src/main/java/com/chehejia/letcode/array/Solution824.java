package com.chehejia.letcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/4/21 4:58 PM
 **/
public class Solution824 {

    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        StringBuffer res = new StringBuffer();
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            StringBuffer sb = new StringBuffer();
            if (set.contains(s.charAt(0))) {
                res.append(s);
                res.append("ma");
            } else {
                res.append(s.substring(1));
                res.append("ma");
                res.append(s.substring(0, 1));
            }
            for (int j = 0; j < i + 1; j++) {
                res.append("a");
            }
            res.append(" ");
        }
        return res.toString();
    }
}
