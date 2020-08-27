package com.yonyou.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/28
 */
public class Solution209 {

  public int minSubArrayLen(int s, int[] nums) {
    int minSal = Integer.MAX_VALUE;
    if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] < s)) {
      return 0;
    }
    int[] prefixSum = new int[nums.length + 1];
    // 先算出前缀和 [2,5,6,8,12,15]
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= s) {
        return 1;
      }
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    // 遍历相减得出大于等于s的值
    int left = 0;
    int right = 1;
    while (left < right && right < prefixSum.length) {
      if (prefixSum[right] - prefixSum[left] < s) {
        right++;
      } else {
        minSal = Math.min(right - left, minSal);
        left++;
      }
    }
    return minSal == Integer.MAX_VALUE ? 0 : minSal;
  }

  public static void main(String[] args) {
    Solution209 solution209 = new Solution209();
    int count = solution209.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5});
    System.out.println(count);
  }
}
