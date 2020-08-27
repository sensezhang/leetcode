package com.yonyou.letcode.recursion;

import java.util.HashSet;
import java.util.Set;

class Solution433 {
  int minPath = Integer.MAX_VALUE;
  public int minMutation(String start, String end, String[] bank) {
    dfs(start, end, bank, 0, new HashSet<>());
    return minPath == Integer.MAX_VALUE ? -1 : minPath;
  }

  private void dfs(String start, String end, String[] bank, int c, Set<String> step) {
    if (start.equals(end)) {
      minPath = Math.min(minPath, c);
      return;
    }
    for (String str : bank) {
      int diff = 0;
      for (int i = 0; i < start.length(); i++) {
        if (str.charAt(i) != start.charAt(i)) {
          if (diff++ > 1) {
            break;
          }
        }
      }
      if (diff == 1 && !step.contains(str)) {
        step.add(str);
        dfs(str, end, bank, c + 1, step);
        step.remove(str);
      }
    }
  }



  public static void main(String[] args) {
    String start = "AAAACCCC";
    String end = "CCCCCCCC";
    String[] bank = new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
    Solution433 solution433 = new Solution433();
    int count = solution433.minMutation(start, end, bank);
    System.out.println(count);
  }
}