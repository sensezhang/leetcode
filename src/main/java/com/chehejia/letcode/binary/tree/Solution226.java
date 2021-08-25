package com.chehejia.letcode.binary.tree;

/**
 * 链表反转
 * @Author: zhangwbin
 * @Date: 2020/6/17
 */
public class Solution226 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    invertTree(root.left);
    invertTree(root.right);
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    return root;
  }

  public static void main(String[] args) {
    TreeNode treeNode = TreeNodeUtil.buildTreeNode(new int[]{4,2,7,1,3,6,9});
    Solution226 solution226 = new Solution226();
    TreeNode result = solution226.invertTree(treeNode);
    TreeNodeUtil.printTreeNode(result);
  }
}
