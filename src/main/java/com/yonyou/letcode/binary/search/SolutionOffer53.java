package com.yonyou.letcode.binary.search;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/3
 */
public class SolutionOffer53 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int count = 0;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        int i = mid - 1;
        int j = mid + 1;
        count++;
        while (i >= 0 && nums[i--] == nums[mid]) {
          count++;
        }
        while (j < nums.length && nums[j++] == nums[mid]) {
          count++;
        }
        break;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    SolutionOffer53 solutionOffer53 = new SolutionOffer53();
    int c = solutionOffer53.search(new int[]{5,7,7,8,8,10}, 8);
    System.out.println(c);
  }
}
