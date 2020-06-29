package com.yonyou.letcode.node;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历 左->右->根
 * @Author: zhangwbin
 * @Date: 2020/6/15
 */
public class Solution590 {
  List<Integer> result = new ArrayList<>();
  public List<Integer> postorder(Node root) {
    dfs(root);
    return result;
  }
  private void dfs(Node root){
    if (root == null||root.children == null) {
      return;
    }
    List<Node> list = root.children;
    for (int i = 0; i < list.size(); i++) {
      dfs(list.get(i));
      result.add(list.get(i).val);
    }
  }
}
