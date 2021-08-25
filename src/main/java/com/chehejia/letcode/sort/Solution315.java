package com.chehejia.letcode.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/11
 */
public class Solution315 {

  public List<Integer> countSmaller(int[] nums) {
    int len = nums.length;
    Integer[] result = new Integer[len];
    result[len - 1] = 0;
    // 从后往前遍历
    for (int i = len - 2; i >= 0; i--) {
      int a = nums[i];
      int count = 0;
      int j = i + 1;
      while (j < len && a > nums[j]) {
        count++;
        j++;
      }
      result[i] = count;
      sort(nums, i, count);
    }
    return Arrays.asList(result);
  }
  private void sort(int[] nums, int i, int count){
    int newnum = nums[i];
    for (int j = 0; j < count; j++) {
      nums[i + j] = nums[i + j + 1];
    }
    nums[i + count] = newnum;
  }

  public static void main(String[] args) {
    Solution315 solution315 = new Solution315();
    List<Integer> list = solution315.countSmaller(new int[]{5,2,6,1});
    System.out.println(list);
  }
}
