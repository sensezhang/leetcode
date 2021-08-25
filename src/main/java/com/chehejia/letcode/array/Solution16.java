package com.chehejia.letcode.array;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @Author: zhangwbin
 * @Date: 2020/6/24
 */
public class Solution16 {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int min = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length; i++) {
      int start = i + 1;
      int end = nums.length - 1;
      while (start < end) {
        int sum = nums[i] + nums[start] + nums[end];
        if (Math.abs(target - min) > Math.abs(target - sum)) {
          min = sum;
        }
        if (sum > target) {
          end--;
        } else if (sum < target){
          start++;
        } else {
          return min;
        }
      }
    }
    return min;
  }

  public static void main(String[] args) {
    Solution16 solution16 = new Solution16();
    int[] nums = new int[]{-1, 2, 1, -4};
    int s = solution16.threeSumClosest(nums, 1);
    System.out.println(s);
  }
}
