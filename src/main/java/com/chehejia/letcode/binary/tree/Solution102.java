package com.chehejia.letcode.binary.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/7
 */
public class Solution102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> deque = new LinkedList<>();
    deque.add(root);

    while (!deque.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = deque.size();
      for (int i = 0 ; i < size; i++) {
        TreeNode cur = deque.pollFirst();
        list.add(cur.val);
        if (cur.left != null) deque.add(cur.left);
        if (cur.right != null) deque.add(cur.right);
      }
      result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {

    TreeNode root = TreeNodeUtil.buildTreeNode(new int[]{3,9,20,-1,-1,15,7});
    Solution102 solution102 = new Solution102();
    List<List<Integer>> result = solution102.levelOrder(root);
    System.out.println(result);
  }
}
