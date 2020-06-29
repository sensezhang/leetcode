package com.yonyou.letcode.binary.tree;

/**
 * 判断二叉树是否是对称二叉树
 * @Author: zhangwbin
 * @Date: 2020/6/29
 */
public class SolutionO28 {
  public boolean isSymmetric(TreeNode root) {
    return root == null ? true : recur(root.left, root.right);
  }

  boolean recur(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null || left.val != right.val) {
      return false;
    }
    return recur(left.left, right.right) && recur(left.right, right.left);
  }
}
