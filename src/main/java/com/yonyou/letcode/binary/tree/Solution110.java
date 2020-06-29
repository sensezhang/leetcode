package com.yonyou.letcode.binary.tree;

/**
 * 判断平衡二叉树
 * @Author: zhangwbin
 * @Date: 2020/6/29
 */
public class Solution110 {

  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHight = height(root.left);
    int rightHight = height(root.right);
    if (leftHight >= 0 && rightHight >= 0 && Math.abs(leftHight - rightHight) <= 1) {
      return Math.max(leftHight, rightHight) + 1;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    TreeNode treeNode = TreeNodeUtil.buildTreeNode(new int[]{2,-1,3,-1,4,-1,5,-1,6});
    Solution110 solution110 = new Solution110();
    boolean isBalance = solution110.isBalanced(treeNode);
    System.out.println(isBalance);
  }

}
