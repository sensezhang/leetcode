package com.chehejia.letcode.array;

import java.util.Arrays;

/**
 * 双指针解法，贪心，先排序，再拿第一个饼干给第一个小孩儿，若不满足，继续往后
 * @Author: zhangwbin
 * @Date: 2020/6/12
 */
public class Solution455 {

  public int findContentChildren(int[] g, int[] s) {
    int i = 0;
    int j = 0;
    int count = 0;
    Arrays.sort(g);
    Arrays.sort(s);
    while (i < g.length && j < s.length) {
      if (g[i] <= s[j]) {
        count++;
        i++;
        j++;
      } else {
        j++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Solution455 solution455 = new Solution455();
    int[] g = new int[]{1,2,3};
    int[] s = new int[]{1, 1};
    int count = solution455.findContentChildren(g, s);
    System.out.println(count);
  }
}
