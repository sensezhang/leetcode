package com.yonyou.letcode.array;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/16
 */
public class Solution5185 {

  public boolean threeConsecutiveOdds(int[] arr) {
    int i = 0;

    while (i < arr.length) {
      int count = 0;
      while (i < arr.length && (arr[i] & 1) == 1) {
        count++;
        i++;
        if (count > 2) {
          return true;
        }
      }
      i++;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution5185 solution5185 = new Solution5185();
    boolean a = solution5185.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12});
    System.out.println(a);
  }
}
