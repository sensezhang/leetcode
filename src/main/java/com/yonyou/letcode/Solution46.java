package com.yonyou.letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/6
 */
public class Solution46 {
  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
    if (nums != null && nums.length != 0) {
      recur(0, new ArrayList<>(),  nums);
    }
    return result;
  }

  public void recur(int level, List<Integer> list, int[] nums) {
    // terminator
    if (level >= nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    // process
    for (int i = 0; i < nums.length; i++) {
      if (!list.contains(nums[i])) {
        list.add(nums[i]);
        recur(level + 1, list, nums);
        list.remove(list.indexOf(nums[i]));
      }
    }
    // restore
  }

  public static void main(String[] args) {
    Solution46 solution46 = new Solution46();
    List<List<Integer>> result = solution46.permute(new int[]{1,2,3});
    System.out.println(result);
  }
}
