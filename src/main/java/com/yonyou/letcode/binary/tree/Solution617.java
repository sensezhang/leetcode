package com.yonyou.letcode.binary.tree;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/29
 */
public class Solution617 {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeNode node = new TreeNode(t1.val + t2.val);
    node.left = mergeTrees(t1.left, t2.left);
    node.right = mergeTrees(t1.right, t2.right);
    return node;
  }

  public static void main(String[] args) {
    TreeNode t1 = TreeNodeUtil.buildTreeNode(new int[]{1,3,2,5,-1});
    TreeNode t2 = TreeNodeUtil.buildTreeNode(new int[]{2,1,3,-1,4,-1,7});
    Solution617 solution617 = new Solution617();
    TreeNode node = solution617.mergeTrees(t1, t2);
    TreeNodeUtil.printTreeNode(node);
  }
}
