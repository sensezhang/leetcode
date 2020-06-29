package com.yonyou.letcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @Author: zhangwbin
 * @Date: 2020/5/27
 */
public class Solution15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
          if (nums[left] + nums[right] == -nums[i]) {
            result.add(Arrays.asList(nums[i], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            left++;
            right--;
          } else if (nums[left] + nums[right] < -nums[i]) {
            left++;
          } else {
            right--;
          }
        }
      }

    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-2, 0, 1, 1, 2};
    Solution15 solution15 = new Solution15();
    List<List<Integer>> list = solution15.threeSum(nums);
    System.out.println(list);
  }
}
