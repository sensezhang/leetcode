package com.yonyou.letcode.array;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/2
 */
public class Solution5478 {

  public int maxSum(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int m = nums1.length;
    int n = nums2.length;
    long sum = 0;
    // 判断下个相等的值

    while (i < m && j < n) {
      int nextSum1 = 0;
      int nextSum2 = 0;
      while (i < m && j < n) {
        if (nums1[i] < nums2[j]) {
          nextSum1 += nums1[i++];
        } else if (nums1[i] > nums2[j]) {
          nextSum2 += nums2[j++];
        } else {
          nextSum1 += nums1[i];
          nextSum2 += nums2[j];
          break;
        }
      }
      if (i >= m -1 || j >= n - 1) {
        while (i < m -1) {
          nextSum1 += nums1[++i];
        }
        while (j < n - 1) {
          nextSum2 += nums2[++j];
        }
      }
      i++;
      j++;
      sum += nextSum1 > nextSum2 ? nextSum1 : nextSum2;
    }
    return (int)(sum % (Math.pow(10, 9) + 7));
  }

  public static void main(String[] args) {
    Solution5478 solution5478 = new Solution5478();
    int[] num1 = new int[]{5,9,11,15,17,25,29};
    int[] num2 = new int[]{6,12,15};
    int sum = solution5478.maxSum(num1, num2);
    System.out.println(sum);
  }

}
