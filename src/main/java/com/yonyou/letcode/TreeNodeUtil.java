package com.yonyou.letcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/30
 */
public class TreeNodeUtil {

  /**
   * [1,-1,2,3]
   * @param arr
   * @return
   */
  public static TreeNode buildTreeNode(int[] arr) {
    if (arr == null || arr.length == 0 || arr[0] < 0) {
      return null;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    TreeNode root = new TreeNode(arr[0]);
    queue.add(root);
    for (int i = 1; i < arr.length && !queue.isEmpty(); i+=2) {
      TreeNode curr = queue.poll();
      if (arr[i] >= 0) {
        curr.left = new TreeNode(arr[i]);
        queue.add(curr.left);
      }
      if (arr[i+1] >= 0) {
        curr.right = new TreeNode(arr[i+1]);
        queue.add(curr.right);
      }
    }
    return root;
  }

//  /**
//   * 前序遍历 根->左->右
//   */
//  public static int[] traverseFrontTreeNode(TreeNode root) {
//    if (root == null) {
//      return new int[]{};
//    }
//
//  }
//
//  public static List<List<Integer>> traverseTreeNode(TreeNode root) {
//    List<List<Integer>> result = new ArrayList<>();
//    if (root == null) {
//      return result;
//    }
//    Deque<TreeNode> treeNodes = new LinkedList<>();
//    treeNodes.push(root);
//    while (!treeNodes.isEmpty()) {
//      TreeNode cur = treeNodes.pop();
//      if()
//
//    }
//    return result;
//  }

  public static void main(String[] args) {
    TreeNode treeNode = buildTreeNode(new int[]{1,-1,2,3,4});

  }
}
