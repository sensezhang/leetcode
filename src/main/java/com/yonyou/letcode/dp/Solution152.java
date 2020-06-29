package com.yonyou.letcode.dp;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/26
 */
public class Solution152 {
  public int maxProduct(int[] nums) {
    int dpMax = nums[0];
    int dpMin = nums[0];
    int maxResult = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) {
        int max = dpMax;
        dpMax = Math.max(dpMin * nums[i], nums[i]);
        dpMin = Math.min(max * nums[i], nums[i]);
      } else {
        dpMax = Math.max(dpMax * nums[i], nums[i]);
        dpMin = Math.min(dpMin * nums[i], nums[i]);
      }
      maxResult = Math.max(maxResult, dpMax);
    }
    return maxResult;
  }

  public static void main(String[] args) {
    Solution152 solution152 = new Solution152();
    System.out.println(solution152.maxProduct(new int[]{-4, -3, -2}));
  }
}
