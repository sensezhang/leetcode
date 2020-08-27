package com.yonyou.letcode.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/27
 */
public class Solution1488 {
  public int[] avoidFlood(int[] rains) {
    if (rains == null || rains.length == 0) {
      return rains;
    }
    int len = rains.length;
    int[] ans = new int[len];
    Arrays.fill(ans, -1);
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < len; i++) {
      if (rains[i] > 0) {
        if (set.contains(rains[i])) {
          return new int[]{};
        } else {
          set.add(rains[i]);
        }
      } else if (rains[i] == 0) {
        // set为空,说明湖泊都没水
        if (set.isEmpty()) {
          ans[i] = 1;
        } else {
          // 选择抽干一个湖泊
          for (int j = i; j < len; j++) {
            if (set.contains(rains[j])) {
              ans[i] = rains[j];
              set.remove(rains[j]);
              break;
            }
          }
        }

      }

    }
    return ans;
  }

  public static void main(String[] args) {
    Solution1488 solution1488 = new Solution1488();
    int[] a = solution1488.avoidFlood(new int[]{69,0,0,0,69});
    System.out.println(Arrays.toString(a));
  }
}
