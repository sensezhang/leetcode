package com.chehejia.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/11
 */
public class Solution33 {

  public int search(int[] nums, int target) {
    if (nums == null) {
      return -1;
    }
    if (nums[0] == target) {
      return 0;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid  = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[0] <= nums[mid]) {
        if (target >= nums[0] && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[nums.length-1] > target && nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution33 solution33 = new Solution33();
    int[] nums = new int[]{3, 1};
    int target = 3;
    int result = solution33.search(nums, target);
    System.out.println(result);
  }
}
