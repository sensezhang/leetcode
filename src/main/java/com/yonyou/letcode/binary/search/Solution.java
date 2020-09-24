package com.yonyou.letcode.binary.search;

/**
 * @Author: zhangwbin
 * @Date: 2020/9/24
 */
public class Solution {

  public int getCount(int[] arr, int search) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = ((right - left) >> 1) + left;
      if (search < arr[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return arr.length - left;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.getCount(new int[]{1,1,2,2,3,5,7}, 4) + "------" + 2);
    System.out.println(solution.getCount(new int[]{1,1,2,2,3,5,7}, 0) + "------" + 7);
    System.out.println(solution.getCount(new int[]{1,1,2,2,3,5,7}, 2) + "------" + 3);
    System.out.println(solution.getCount(new int[]{1,1,2,2,3,5,7}, 6) + "------" + 1);
    System.out.println(solution.getCount(new int[]{1,1,2,2,3,5,7}, 9) + "------" + 0);
    System.out.println(solution.getCount(new int[]{1,1,2,2,2,3,5,7}, 2) + "------" + 3);
  }

}
