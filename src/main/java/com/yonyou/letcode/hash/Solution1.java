package com.yonyou.letcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    // hash法 时间复杂度O(n),空间复杂度O(n)
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i< nums.length; i++) {
      int m = target - nums[i];
      if (map.containsKey(m)) {
        return new int[]{map.get(m), i};
      }
      map.put(nums[i], i);
    }
    return null;

   /* //两次遍历，加排序，使用hash存储结构，用来解决数据不重复时查询还可以
    数据重复时查询并不能找到准确的下标
    Map<Integer, Integer> map = new HashMap<>();
    for (int j = 0; j < nums.length; j++) {
      map.put(nums[j], j);
    }
    Arrays.sort(nums);
    for (int i = 0, j = nums.length - 1; i < j; ) {
      if (nums[i] + nums[j] < target) {
        i++;
        continue;
      }
      if (nums[i] + nums[j] > target) {
        j--;
        continue;
      }
      if (nums[i] + nums[j] == target) {
        return new int[]{map.get(nums[i]), map.get(nums[j])};
      }
    }
    return null;*/
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 4};
    Solution1 solution1 = new Solution1();
    int[] result = solution1.twoSum(nums, 6);
    System.out.println(Arrays.toString(result));
  }

}
