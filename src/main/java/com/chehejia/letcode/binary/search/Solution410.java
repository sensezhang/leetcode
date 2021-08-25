package com.chehejia.letcode.binary.search;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/25
 */
public class Solution410 {
  public int splitArray(int[] nums, int m) {
    int left = 0;
    int right = 0;
    for (int i : nums) {
      if (left < i) {
        left = i;
      }
      right += i;
    }

    while (left < right) {
      int mid = left + ((right - left) >> 1);
      int tmp = 0;
      int cur = 1;
      for (int i : nums) {
        tmp += i;
        if (tmp > mid) {
          tmp = i;
          cur++;
        }
      }
      // 如果cur>m,说明划分的子数组多了，最小值太小了，改为中位数加1。否则子数组划分少了，最大值太大了，最大值改为中位数
      if (cur > m) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    Solution410 solution410 = new Solution410();
    int i = solution410.splitArray(new int[]{7,2,5,10,8}, 2);
    System.out.println(i);
  }
}
