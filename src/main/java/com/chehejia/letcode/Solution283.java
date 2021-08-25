package com.chehejia.letcode;

import java.util.Arrays;

/**
 * 移动零
 * @Author: zhangwbin
 * @Date: 2020/5/19
 */
public class Solution283 {

  public void moveZeroes(int[] nums) {
    // 交换位置，时间复杂度O(n),空间复杂度O(1)
    int zero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[zero] = nums[i];
        if (zero != i) {
          nums[i] = 0;
        }
        zero ++;
      }
    }
  }
  public static void main(String[] args) {
    int[] ints = new int[]{0,1,0,3,12};
    Solution283 solution283 = new Solution283();
    solution283.moveZeroes(ints);
    System.out.println(Arrays.toString(ints));
  }
}
