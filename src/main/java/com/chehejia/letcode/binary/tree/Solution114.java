package com.chehejia.letcode.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/2
 */
public class Solution114 {
  public void flatten(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    dfs(root, list);
    TreeNode cur = root;

    for (int i = 0; i < list.size(); i++) {
      cur.val = list.get(i);
      if (cur.left != null) {
        cur.left = null;
      }
      if (cur.right == null && i < list.size() - 1) {
        cur.right = new TreeNode(0);
      }
      cur = cur.right;
    }
  }

  private void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    dfs(root.left, list);
    dfs(root.right, list);
  }

  public static void main(String[] args) {
    Solution114 solution114 = new Solution114();
    TreeNode node = TreeNodeUtil.buildTreeNode(new int[]{1,2,5,3,4,-1,6});
    solution114.flatten(node);
    TreeNodeUtil.printTreeNode(node);
  }
}
