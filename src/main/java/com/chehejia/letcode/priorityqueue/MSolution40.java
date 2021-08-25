package com.chehejia.letcode.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/30
 */
public class MSolution40 {

  public int[] getLeastNumbers(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k < 1) {
      return new int[]{};
    }
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
    for (int i = 0; i< arr.length; i++) {
      priorityQueue.add(arr[i]);
    }
    int[] result = new int[k];
    for (int j = 0; j < k; j++) {
      result[j] = priorityQueue.poll();
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{3,2,1, 0};
    MSolution40 mSolution40 = new MSolution40();
    int[] result = mSolution40.getLeastNumbers(arr, 2);
    System.out.println(Arrays.toString(result));
  }
}
