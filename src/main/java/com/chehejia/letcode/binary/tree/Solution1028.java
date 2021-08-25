package com.chehejia.letcode.binary.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/18
 */
public class Solution1028 {

  public TreeNode recoverFromPreorder(String S) {
    Deque<TreeNode> deque = new LinkedList<>();
    int cur = 0;

    while (cur < S.length()) {
      int level = 0;
      while (S.charAt(cur) == '-') {
        cur++;
        level++;
      }
      int val = 0;
      while (cur < S.length() && Character.isDigit(S.charAt(cur))) {
        val = Integer.parseInt(S.charAt(cur) + "");
        cur++;
      }
      TreeNode node = new TreeNode(val);
      if (level == deque.size()) {
        if (deque.peek() != null) {
          deque.peek().left = node;
        }
      } else {
        while (level < deque.size()) {
          deque.pop();
        }
        deque.peek().right = node;
      }
      deque.push(node);
    }
    while (deque.size() > 1) {
      deque.pop();
    }
    return deque.pop();
  }


  public static void main(String[] args) {
    String str = "1-2--3--4-5--6--7";
    Solution1028 solution1028 = new Solution1028();
    TreeNode treeNode = solution1028.recoverFromPreorder(str);
    TreeNodeUtil.printTreeNode(treeNode);
  }
}
