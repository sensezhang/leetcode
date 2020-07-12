package com.yonyou.letcode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/12
 */
public class Solution107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> ant = new LinkedList<>();
    if (root == null) {
      return ant;
    }
    LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodes.poll();
        list.add(node.val);
        if (node.left != null) {
          nodes.add(node.left);
        }
        if (node.right != null) {
          nodes.add(node.right);
        }
      }
      ant.addFirst(list);
    }
    return ant;
  }

  public static void main(String[] args) {
    Solution107 solution107 = new Solution107();
    TreeNode root = TreeNodeUtil.buildTreeNode(new int[]{3,9,20,-1,-1,15,7});
    List<List<Integer>> list = solution107.levelOrderBottom(root);
    System.out.println(list);
  }
}
