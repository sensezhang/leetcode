package com.yonyou.letcode.node;

import java.util.ArrayList;
import java.util.List;

/**
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * @Author: zhangwbin
 * @Date: 2020/5/28
 */
public class Solution429 {
  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> levelOrder(Node root) {

//    List<List<Integer>> result = new ArrayList<>();
//    Deque<Node> deque = new LinkedList<>();
//    deque.push(root);
//    while (!deque.isEmpty()) {
//      List<Integer> level = new ArrayList<>();
//      int size = deque.size();
//      for (int i = 0; i < size; i++){
//        Node node = deque.pop();
//        level.add(node.val);
//        if (node.children != null) {
//          deque.addAll(node.children);
//        }
//      }
//      result.add(level);
//    }
//    return result;
    traverseNode(root, 0);
    return result;
  }

  private void traverseNode(Node root, int level) {
    if (root == null) {
      return;
    }
    if (result.size() <= level) {
      result.add(new ArrayList<Integer>());
    }
    result.get(level++).add(root.val);
    List<Node> childrens = root.children;
    if (childrens != null) {
      for (int i = 0; i < childrens.size(); i++) {
        traverseNode(childrens.get(i), level);
      }
    }
  }
  public static void main(String[] args) {
    List<Node> children1 = new ArrayList<>();
    List<Node> children2 = new ArrayList<>();
    children2.add(new Node(5));
    children2.add(new Node(6));
    children1.add(new Node(3, children2));
    children1.add(new Node(2));
    children1.add(new Node(4));
    Node node = new Node(1, children1);
    Solution429 solution429 = new Solution429();
    List<List<Integer>> list = solution429.levelOrder(node);
    System.out.println(list);
  }
}
