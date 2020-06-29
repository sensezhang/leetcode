package com.yonyou.letcode.recursion;

import java.util.HashSet;

class Solution433 {
    int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }
    private void dfs (HashSet<String> step, int stepCount, 
        String current, String end, String[] bank) {
      if (current.equals(end)) {
        minStepCount = Math.min(stepCount, minStepCount);
        return;
      }
        for (String str: bank) {
            int diff = 0;
          for (int i = 0; i < str.length(); i++) {
            if (current.charAt(i) != str.charAt(i)) {
              if (++diff > 1) {
                break;
              }
            }
          }
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }

  public static void main(String[] args) {
    String start = "AACCGGTT";
    String end = "AAACGGTA";
    String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
    Solution433 solution433 = new Solution433();
    int count = solution433.minMutation(start, end, bank);
    System.out.println(count);
  }
}