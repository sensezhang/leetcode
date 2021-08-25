package com.chehejia.letcode.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: zhangwbin
 * @Date: 2020/9/7
 */
public class Solution347 {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      Integer counter = map.getOrDefault(num, 0);
      counter += 1;
      map.put(num, counter);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> o2[1] - o1[1]);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int[] tmp = new int[]{entry.getKey(), entry.getValue()};
      queue.offer(tmp);
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = queue.poll()[0];
    }
    return result;
  }
}
