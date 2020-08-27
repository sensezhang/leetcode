package com.yonyou.letcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/23
 */
public class Solution5495 {
  public List<Integer> mostVisited(int n, int[] rounds) {
    int maxTime = 0;
    if (rounds.length == 1) {
      return null;
    }
    int[] s = new int[n];
    for (int i = 1; i < rounds.length; i++) {
      if (rounds[i - 1] < rounds[i]) {
        int j = rounds[i - 1];
        while (j < rounds[i]) {
          s[j - 1]++;
          j++;
        }
      } else {
        int j = rounds[i - 1];
        while (j <= n) {
          s[j - 1]++;
          j++;
        }
        j = 1;
        while (j <= rounds[i]) {
          s[j - 1]++;
          j++;
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (maxTime < s[i]) {
        list.clear();
        list.add(i);
      } else if (maxTime == s[i]) {
        list.add(i);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    Solution5495 solution5495 = new Solution5495();
    solution5495.mostVisited(4, new int[]{1,3,1,2});
  }
}
