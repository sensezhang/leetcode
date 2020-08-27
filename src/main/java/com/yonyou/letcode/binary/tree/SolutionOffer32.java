package com.yonyou.letcode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/30
 */
public class SolutionOffer32 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    LinkedList<TreeNode> deque = new LinkedList<>();
    deque.add(root);
    while(!deque.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = deque.pop();
        list.add(cur.val);
        if (cur.left != null) {
          deque.add(cur.left);
        }
        if (cur.right != null) {
          deque.add(cur.right);
        }
      }
      result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {
    SolutionOffer32 solutionOffer32 = new SolutionOffer32();
    solutionOffer32.levelOrder(TreeNodeUtil.buildTreeNode(new int[]{3,9,20,-1,-1,15,7}));
  }
}
