package com.yonyou.letcode.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/29
 */
public class Solution655 {
  public List<List<String>> printTree(TreeNode root) {
    // 求树的高度
    int hight = dfs(root);
    // 集合长度是 (2^hight) - 1 即 (1 << hight) - 1
    int size = (1 << hight) - 1;
    List<List<String>> result = new ArrayList<>(hight);
    for (int i = 0; i < hight; i++) {
      String[] strs = new String[size];
      Arrays.fill(strs, "");
      result.add(Arrays.asList(strs));
    }
    // 填充result值
    fill(root, result, 0, 0, size);
    return result;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHight = dfs(root.left);
    int rightHight = dfs(root.right);
    return Math.max(leftHight, rightHight) + 1;
  }

  private void fill(TreeNode node, List<List<String>> res, int level, int left, int right) {
    if (node == null) {
      return;
    }
    // 取中间位置
    int mid = (left + right) / 2;
    // 在相应位置填上数字
    res.get(level).set(mid, Integer.toString(node.val));
    // 填充左子树
    fill(node.left, res, level + 1, left, mid - 1);
    // 填充右子树
    fill(node.right, res, level + 1, mid + 1, right);
  }

  public static void main(String[] args) {
    Solution655 solution655 = new Solution655();
    TreeNode root = TreeNodeUtil.buildTreeNode(new int[]{1, 2, -1});
    List<List<String>> result = solution655.printTree(root);
    System.out.println(result);
  }
}
