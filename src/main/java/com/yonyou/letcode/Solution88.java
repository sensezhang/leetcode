package com.yonyou.letcode;

import java.util.Arrays;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/23
 */
public class Solution88 {


  public void merge(int[] nums1, int m, int[] nums2, int n) {
    /*System.arraycopy(nums2,0, nums1, m, n);
    Arrays.sort(nums1);*/

//    int[] nums3 = new int[m];
//    System.arraycopy(nums1, 0, nums3, 0, m);
//    int i = 0, j = 0, p = 0;
//    while (i < m && j < n) {
//      nums1[p++] = nums3[i] > nums2[j] ? nums2[j++] : nums3[i++];
//    }
//    if (i < m) {
//      System.arraycopy(nums3, i, nums1, p, m - i);
//    }
//    if (j < n) {
//      System.arraycopy(nums2, j, nums1, p, n - j);
//    }

    int i = m - 1, j = n - 1;
    int p = m + n - 1;
    while (i >= 0 && j >= 0) {
      nums1[p--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
    System.arraycopy(nums2, 0, nums1, 0, j + 1);
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 0, 0, 0};
    int[] b = new int[]{2, 5, 6};
    Solution88 solution88 = new Solution88();
    solution88.merge(a, 3, b, 3);
    System.out.println(Arrays.toString(a));
  }
}
