package com.chehejia.letcode.binary.tree;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/7
 */
public class Solution112 {
  public boolean hasPathSum(TreeNode root, int sum) {
    return sumTree(root, 0, sum);
  }

  private boolean sumTree(TreeNode root, int sum, int target) {
    if (root == null) {
      if (sum == target) {
        return true;
      }
      return false;
    }
    sum += root.val;
    boolean leftsum = sumTree(root.left, sum, target);
    boolean rightsum = sumTree(root.right, sum, target);
    return leftsum || rightsum;
  }
}
