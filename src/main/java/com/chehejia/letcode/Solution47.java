package com.chehejia.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/6
 */
public class Solution47 {

  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums != null && nums.length != 0) {
      Arrays.sort(nums);
      recur(0,nums,new boolean[nums.length], new LinkedList<>());
    }
    return result;
  }

  private void recur(int level, int[] nums, boolean[] used, Deque<Integer> list) {
    if (level >= nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }

      // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
      // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      list.addLast(nums[i]);
      used[i] = true;
      recur(level+1, nums, used, list);
      list.removeLast();
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    Solution47 solution47 = new Solution47();
    List<List<Integer>> result = solution47.permuteUnique(new int[]{1,1,2});
    System.out.println(result);
  }
}
