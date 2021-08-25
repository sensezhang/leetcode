package com.chehejia.letcode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/17
 */
public class Solution103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    int path = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean cnt = (path & 1) == 1;
      LinkedList<TreeNode> tmp = new LinkedList<>();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode next = queue.poll();
        // 偶数 正 奇数 反
        if (cnt) {
          list.add(0, next.val);
        } else {
          list.add(next.val);
        }
        if (next.left != null) {
          tmp.add(next.left);
        }
        if (next.right != null) {
          tmp.add(next.right);
        }

      }
      queue = tmp;
      result.add(list);
      path++;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution103 solution103 = new Solution103();
    TreeNode root = TreeNodeUtil.buildTreeNode(new int[]{1,2,3,4,-1,-1,5});
    List<List<Integer>> list = solution103.zigzagLevelOrder(root);
    System.out.println(list);

    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    int len = linkedList.size();
    for (int i = 0; i < len; i++) {
      System.out.println(linkedList.pollFirst());
    }
  }
}
