package com.chehejia.letcode;

import java.util.Stack;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/15
 */
public class Solution42 {
  public int trap(int[] height) {
//    if (height == null || height.length < 2){
//      return 0;
//    }
//    int sum = 0;
//    int[] leftMaxArr = new int[height.length];
//    int[] rightMaxArr = new int[height.length];
//    for (int i = 1; i < height.length - 1; i++) {
//      leftMaxArr[i] = Math.max(leftMaxArr[i - 1], height[i - 1]);
//    }
//    for (int i = height.length - 2; i >= 0; i--) {
//      rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i + 1]);
//    }
//    for(int i = 1; i < height.length - 1; i++) {
//      int minSide = Math.min(leftMaxArr[i], rightMaxArr[i]);
//      if (minSide > height[i]) {
//        sum = sum + (minSide - height[i]);
//      }
//    }
//    return sum;
    if (height == null || height.length < 2){
      return 0;
    }
    int ant = 0;
    Stack<Integer> stack = new Stack<>();
    int concurrent = 0;
    while (concurrent < height.length) {
      while (!stack.isEmpty() && height[concurrent] > height[stack.peek()]) {
        int i = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        int left = stack.peek();
        int side = concurrent - left - 1;
        int high = Math.min(height[concurrent], height[left]) - height[i];
        ant += high * side;
      }
      stack.push(concurrent++);
    }
    return ant;
  }

  public static void main(String[] args) {
    Solution42 solution42 = new Solution42();
    int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    int sum = solution42.trap(height);
    System.out.println(sum);
  }
}
