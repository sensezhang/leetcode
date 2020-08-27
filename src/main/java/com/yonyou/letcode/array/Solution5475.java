package com.yonyou.letcode.array;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/2
 */
public class Solution5475 {
  public int countGoodTriplets(int[] arr, int a, int b, int c) {
    int count = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = i + 1; j < arr.length - 1; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Solution5475 solution5475 = new Solution5475();
    solution5475.countGoodTriplets(new int[]{3,0,1,1,9,7}, 7, 2, 3);
  }
}
