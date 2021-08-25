package com.chehejia.letcode.binary.search;

import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * @Author: zhangwbin
 * @Date: 2020/7/2
 */
public class Solution378 {

  /**
   * 优先队列解决
   * @param matrix
   * @param k
   * @return
   */
  public int kthSmallest2(int[][] matrix, int k) {
    // 创建优先队列，长度为k
    PriorityQueue<Integer> pq = new PriorityQueue<>(k);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        pq.add(matrix[i][j]);
      }
    }
    int result = 0;
    for(int i = 0; i < k; i++) {
      result = pq.poll();
    }
    return result;
  }


  /**
   * 二分法查找
   * @param matrix
   * @param k
   * @return
   */
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    // 定义最小值和最大值
    int left = matrix[0][0];
    int right = matrix[n - 1][n - 1];
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      // 检查中间值是否满足
      if (check(matrix, mid, k, n)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean check(int[][] matrix, int mid, int k, int n) {
    int i  = n - 1;
    int j = 0;
    int num = 0;
    while (i >= 0 && j < n) {
      if (matrix[i][j] <= mid) {
        num += i + 1;
        j++;
      } else {
        i--;
      }
    }
    // 计数
    return num >= k;
  }

  public static void main(String[] args) {
    Solution378 solution378 = new Solution378();
    int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
    int k = 8;
    int result = solution378.kthSmallest2(matrix, k);
    System.out.println(result);
  }
}
