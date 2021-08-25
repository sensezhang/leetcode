package com.chehejia.letcode.array;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/2
 */
public class Solution5476 {
  public int getWinner(int[] arr, int k) {
    int win = 0; int lose = 1;
    int count = 0;
    while (count < k) {
      if (arr[win] > arr[lose]) {
        count++;
        lose = setLoseIndex(lose, arr);
      } else {
        int tmp = arr[win];
        arr[win] = arr[lose];
        arr[lose] = tmp;
        count = 1;
        lose = setLoseIndex(lose, arr);
      }
    }
    return arr[win];
  }

  private int setLoseIndex(int lose, int[] arr) {
    lose++;
    if (lose >= arr.length) {
      lose = 1;
    }
    return lose;
  }

  public static void main(String[] args) {
    Solution5476 solution5476 = new Solution5476();
    int a = solution5476.getWinner(new int[]{2,1,3,5,4,6,7}, 2);
    System.out.println(a);
  }
}
