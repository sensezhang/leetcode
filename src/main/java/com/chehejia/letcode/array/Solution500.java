package com.chehejia.letcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/4 2:27 下午
 **/
public class Solution500 {

    public String[] findWords(String[] words) {
        int[] a = new int[]{1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};
        List<String> lists = new ArrayList<>();
        for (String word: words) {
            char[] cs = word.toCharArray();
            boolean isOneLine = true;
            for (int i = 0; i < cs.length - 1; i++) {
                if (a[Character.toLowerCase(cs[i]) - 'a'] != a[Character.toLowerCase(cs[i + 1]) - 'a']) {
                    isOneLine = false;
                    break;
                }
            }
            if (isOneLine) {
                lists.add(word);
            }
        }
        String[] ans = new String[lists.size()];
        for (int i = 0; i < lists.size(); ++i) {
            ans[i] = lists.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution500 solution500 = new Solution500();
        String[] ss = solution500.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        System.out.println(Arrays.toString(ss));
    }
}
