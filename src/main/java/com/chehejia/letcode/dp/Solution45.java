package com.chehejia.letcode.dp;

/**
 * 跳跃游戏Ⅱ 获取到最后需要跳跃的最小步数
 *
 * @Author: zhangwbin
 * @Date: 2020/6/13
 */
public class Solution45 {

  public int jump(int[] nums) {

    int end = 0;
    int step = 0;
    int maxJump = 0;
    for (int i = 0; i < nums.length - 1; i++){
      maxJump = Math.max(maxJump, i + nums[i]);
      if (i == end) {
        step++;
        end = maxJump;
      }
    }
    return step;
  }

  public static void main(String[] args) {
    Solution45 solution45 = new Solution45();
    int[] nums = new int[]{1, 2, 3};
    int step = solution45.jump(nums);
    System.out.println(step);
  }
}
