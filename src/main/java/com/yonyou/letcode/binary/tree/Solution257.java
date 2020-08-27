package com.yonyou.letcode.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/29
 */
public class Solution257 {

  List<String> list = new ArrayList<>();
  public List<String> binaryTreePaths(TreeNode root) {
    dfs(root, "");
    return list;
  }

  private void dfs(TreeNode root, String sb) {
    if (root != null) {
      sb += root.val;
      if (root.left == null && root.right == null) {
        list.add(sb);
        return;
      } else {
        sb += "->";
        dfs(root.left, sb);
        dfs(root.right, sb);
      }
    }
  }

  public static void main(String[] args) {
    Solution257 solution257 = new Solution257();
    List<String> list = solution257.binaryTreePaths(TreeNodeUtil.buildTreeNode(new int[]{1,2,3,-1,5}));
    System.out.println(list);
  }
}
