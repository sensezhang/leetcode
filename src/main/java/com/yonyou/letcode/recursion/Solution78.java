package com.yonyou.letcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/2
 */
public class Solution78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums != null|| nums.length > 0) {
      accessSubsets(0, nums, result, new ArrayList<>());
    }
    return result;
  }

  public void accessSubsets(int level, int[] nums, List<List<Integer>> result, List<Integer> list) {
    if (level == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    accessSubsets(level+1, nums, result, list);

    list.add(nums[level]);
    accessSubsets(level+1, nums, result, list);

    list.remove(list.size()-1);
  }

  public static void main(String[] args) {

    Solution78 solution78 = new Solution78();
    List<List<Integer>> lists = solution78.subsets(new int[]{1,2,3});
    System.out.println(lists);
  }
}
