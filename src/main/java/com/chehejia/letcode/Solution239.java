package com.chehejia.letcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * @Author: zhangwbin
 * @Date: 2020/5/30
 */
public class Solution239 {

  public int[] maxSlidingWindow(int[] nums, int k) {
    /**
     * 优先队列
     */
    PriorityQueue<Integer> queue = new PriorityQueue<>(k, ((o1, o2) -> (o2-o1)));
    int[] result = new int[nums.length - k + 1];
    for (int i = 0; i< nums.length; i++) {
      queue.add(nums[i]);
      if (queue.size() > k) {
        queue.remove(nums[i - k]);
      }
      if (i >= k - 1) {
        result[i + 1 - k] = queue.peek();
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,-1};
    Solution239 solution239 = new Solution239();
    int[] result = solution239.maxSlidingWindow(nums, 1);
    System.out.println(Arrays.toString(result));
  }
}
