package com.chehejia.letcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/13
 */
public class Solution350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      if (map.containsKey(nums2[i])) {
        map.put(nums2[i], map.get(nums2[i]) + 1);
      } else {
        map.put(nums2[i], 1);
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int j = 0; j < nums1.length; j++) {
      if (map.containsKey(nums1[j]) && map.get(nums1[j]) > 0) {
        list.add(nums1[j]);
        map.put(nums1[j], map.get(nums1[j]) - 1);
      }
    }
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    Solution350 solution350 = new Solution350();
    int[] nums1 = new int[]{4,9,5};
    int[] nums2 = new int[]{9,4,9,8,4};
    int[] a = solution350.intersect(nums1, nums2);
    System.out.println(Arrays.toString(a));
  }
}
