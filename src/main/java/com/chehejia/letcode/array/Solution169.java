package com.chehejia.letcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/15
 */
public class Solution169 {
  public int majorityElement(int[] nums) {
    int len = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }
    int ele = nums[0];
    int mid = len >> 1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > mid) {
        ele = entry.getKey();
      }
    }
    return ele;
  }
}
