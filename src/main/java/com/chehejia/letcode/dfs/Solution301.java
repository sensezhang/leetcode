package com.chehejia.letcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/10/27 11:13 上午
 **/
public class Solution301 {

    char[] cs;
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        // 先算出有几对括号
        cs = s.toCharArray();
        int lremoveCount = 0;
        int rremoveCount = 0;
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                lremoveCount++;
            } else if(cs[i] == ')'){
                if (lremoveCount > 0) {
                    lremoveCount--;
                    count += 2;
                } else {
                    rremoveCount++;
                }
            } else {
                count++;
            }
        }
        dfs(0, "", lremoveCount, rremoveCount, count, 0);
        return new ArrayList<>(set);
    }

    private void dfs(int index, String sb, int lremoveCount, int rremoveCount, int count, int score) {
        if (lremoveCount < 0 || rremoveCount < 0 || index > cs.length || score < 0) {
            return;
        }
        if (lremoveCount == 0 && rremoveCount == 0) {
            if (sb.length() == count) {
                set.add(sb);
                return;
            }
        }
        char a = cs[index];
        if (a == '(') {
            dfs(index + 1, sb+a, lremoveCount, rremoveCount, count, score + 1);
            dfs(index + 1, sb, lremoveCount-1, rremoveCount, count, score);
        } else if (a == ')') {
            dfs(index + 1, sb+a, lremoveCount, rremoveCount, count, score - 1);
            dfs(index + 1, sb, lremoveCount, rremoveCount-1, count, score);
        } else {
            dfs(index + 1, sb+a, lremoveCount, rremoveCount, count, score);
        }
    }

    public static void main(String[] args) {
        Solution301 solution301 = new Solution301();
        List<String> sss = solution301.removeInvalidParentheses("()())()");
        System.out.println(sss);
    }
}
