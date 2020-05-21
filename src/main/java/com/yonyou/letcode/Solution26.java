package com.yonyou.letcode;

import java.util.Arrays;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/20
 */
public class Solution26 {

  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    Solution26 solution26 = new Solution26();
    int len = solution26.removeDuplicates(nums);
    System.out.println(len);
    System.out.println(Arrays.toString(nums));
  }
}
