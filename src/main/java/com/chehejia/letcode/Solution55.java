package com.chehejia.letcode;

/**
 * 跳跃游戏
 * @Author: zhangwbin
 * @Date: 2020/6/13
 */
public class Solution55 {

  /**
   * 跳就得了，记录下能跳到的最大的位置，如果过不去，就返回false，否则就一直跳，直到结尾
   *
   * @param nums
   * @return
   */
  public boolean canJump(int[] nums) {
    int jumpMax = 0;
    for (int i = 0; i < nums.length; i++) {
      if (jumpMax < i) {
        return false;
      }
      jumpMax = Math.max(jumpMax, i + nums[i]);
    }
    return true;
  }

  public static void main(String[] args) {
    Solution55 solution55 = new Solution55();
    int[] nums = new int[]{2,3,1,1,4};
    boolean jump = solution55.canJump(nums);
    System.out.println(jump);
  }
}
