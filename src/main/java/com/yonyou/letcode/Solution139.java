package com.yonyou.letcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态规划求解
 * @Author: zhangwbin
 * @Date: 2020/6/25
 */
public class Solution139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    int len = s.length();
    boolean[] dp = new boolean[len + 1];
    dp[0] = true;
    // 从1开始，判断每一位是否可以拆分，直到最后
    for (int i = 1; i <= len; i++) {
      // 从左边最后一位往前推，是否存在可被拆分的值
      for (int j = i - 1; j >=0; j--) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[len];
  }

  public static void main(String[] args) {
    Solution139 solution139 = new Solution139();
    List<String> wordDict = new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");
    System.out.println(solution139.wordBreak("leetcode", wordDict));
  }
}
