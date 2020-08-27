package com.yonyou.letcode.binary.tree;

import java.util.ArrayList;
import java.util.List;

class Solution95 {

  public List<TreeNode> generateTrees(int n) {
    List<TreeNode> results = new ArrayList<>();
    if (n < 1) {
      return results;
    }
    return dfs(1, n);
  }

  private List<TreeNode> dfs(int start, int n) {
    List<TreeNode> list = new ArrayList<>();
    if (start > n) {
      // 如果当前子树
      list.add(null);
      return list;
    }
    for (int i = start; i <= n; i++) {
      List<TreeNode> left = dfs(start, i-1);
      List<TreeNode> right = dfs(i+1, n);

      // 固定左孩子，遍历右孩子
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;
          list.add(root);
        }
      }

    }
    return list;
  }

  public static void main(String[] args) {
    Solution95 solution95 = new Solution95();
    List<TreeNode> list = solution95.generateTrees(3);
    for (TreeNode root : list) {
      TreeNodeUtil.printTreeNode(root);
    }
  }
}