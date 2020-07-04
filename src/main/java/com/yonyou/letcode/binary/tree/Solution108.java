package com.yonyou.letcode.binary.tree;

/**
 * 有序数组构建一棵平衡二叉树
 * @Author: zhangwbin
 * @Date: 2020/7/3
 */
public class Solution108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(nums, 0, nums.length);
  }

  private TreeNode dfs(int[] nums, int left, int right) {
    int mid = left + ((right - left) >> 1);
    TreeNode root = new TreeNode(nums[mid]);
    root.left = dfs(nums, left, mid - 1);
    root.right = dfs(nums, mid + 1, right);
    return root;
  }

  public static void main(String[] args) {

  }
}
