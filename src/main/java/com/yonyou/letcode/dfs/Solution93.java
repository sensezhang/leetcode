package com.yonyou.letcode.dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution93 {
    Set<String> list = new HashSet<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 4, new LinkedList<>());
        return new ArrayList<>(list);
    }

    private void dfs(String s, int level, Deque<String> path) {
        int len = s.length();
        if (len == 0 && level > 0) {
            return;
        }
        // 满4个，字符串用尽，说明ip地址合法
        if(len == 0 && level == 0) {
            list.add(String.join(".", path));
            return;
        }
        // 满4个，并且字符串还有剩余，直接返回
        if (level == 0 && len > 0) {
            return;
        }
        if (s.charAt(0) == '0') {
            path.addLast("0");
            dfs(s.substring(1), level - 1, path);
            path.removeLast();
        } else {
            for (int i = 1; i <= 3; i++) {
                if (i > len) {
                    break;
                }
                String s1 = s.substring(0, i);
                int s2 = Integer.parseInt(s1);
                if (s2 >= 0 && s2 <= 255) {
                    path.addLast(s1);
                    dfs(s.substring(i), level - 1, path);
                    path.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        List<String> list = solution93.restoreIpAddresses("19216811");
        System.out.println(list);
    }
}