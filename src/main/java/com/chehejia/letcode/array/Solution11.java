package com.chehejia.letcode.array;

/**
 * 盛最多水的容器
 * @Author: zhangwbin
 * @Date: 2020/5/24
 */
public class Solution11 {

  public int maxArea(int[] height) {
   /* // 双层遍历暴力求解，时间复杂度n^2
    int max = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j ++) {
        max = Math.max(max, (j-i) * Math.min(height[i], height[j]));
      }
    }
    return max;*/
    // 双指针,时间复杂度O(n)
    int max = 0;
    int front = 0; int last = height.length - 1;

    while (front < last) {
      max = Math.max(max, (last - front) * Math.min(height[front], height[last]));
      if (height[front] < height[last]) {
        front++;
      } else {
        last--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] height = new int[]{1,8,6,2,5,4,8,3,7};
    Solution11 solution11 = new Solution11();
    System.out.println(solution11.maxArea(height));
  }
}
