package com.yonyou.letcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/14
 */
public class Solution1 {

  public int[] twoSum(int[] nums, int target) {
    /*// 暴力求解, 时间复杂度n^2
    for (int i = 0; i < nums.length - 1; i++) {
      int m = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int n = nums[j];
        if (m + n == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;*/
    // hash法
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i< nums.length; i++) {
      int m = target - nums[i];
      if (map.containsKey(m)) {
        return new int[]{map.get(m), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 7, 11, 15};
    Solution1 solution1 = new Solution1();
    int[] result = solution1.twoSum(nums, 9);
    System.out.println(Arrays.toString(result));
  }

}
