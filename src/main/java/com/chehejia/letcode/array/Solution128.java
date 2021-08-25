package com.chehejia.letcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/17
 */
public class Solution128 {
  public int longestConsecutive(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int count = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      int m = 1;

      while (i < nums.length -1) {
        if (nums[i+1] == nums[i]) {
          i++;
          continue;
        }
        if (nums[i + 1] - nums[i] == 1) {
          m++;
        } else {
          break;
        }
        i++;
      }
      count = Math.max(m, count);
    }
    return count;
  }

  public int longestConsecutive1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    int count = 0;
    for (Integer i : set) {
      int tmp = 1;
      while (set.contains(i + 1)) {
        tmp++;
        i++;
      }
      count = Math.max(tmp, count);
    }
    return count;
  }
  public static void main(String[] args) {
    Solution128 solution128 = new Solution128();
    solution128.longestConsecutive1(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});
  }
}
