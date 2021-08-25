package com.chehejia.letcode.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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

  /**
   * [1,-1,2,3]
   * @param arr
   * @return
   */
  public static TreeNode buildTreeNode(Integer[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) {
      return null;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    TreeNode root = new TreeNode(arr[0]);
    queue.add(root);
    for (int i = 1; i < arr.length && !queue.isEmpty(); i+=2) {
      TreeNode curr = queue.poll();
      if (arr[i] != null) {
        curr.left = new TreeNode(arr[i]);
        queue.add(curr.left);
      }
      if (arr[i+1] != null) {
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
  public static void printTreeNode(TreeNode root) {
    List<List<Integer>> result = traverseTreeNode(root);
    System.out.println(result);
  }
  private static List<List<Integer>> traverseTreeNode(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      int size = treeNodes.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode childs = treeNodes.pop();
        list.add(childs.val);
        if (childs.left != null) {
          treeNodes.add(childs.left);
        }
        if (childs.right != null) {
          treeNodes.add(childs.right);
        }
      }
      result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode treeNode = buildTreeNode(new int[]{1,-1,2,3,4});
    printTreeNode(treeNode);
  }
}
