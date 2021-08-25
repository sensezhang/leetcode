package com.chehejia.letcode.binary.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 寻找最近公共祖先
 * @Author: zhangwbin
 * @Date: 2020/6/6
 */
public class Solution236 {

  private TreeNode ans;

  public Solution236() {
    this.ans = null;
  }

  private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null){
      return false;
    }
    boolean lson = dfs(root.left, p, q);
    boolean rson = dfs(root.right, p, q);
    if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
      ans = root;
    }
    return (lson || rson) || (root.val == p.val || root.val == q.val);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    this.dfs(root, p, q);
    return this.ans;
  }

  Map<TreeNode, TreeNode> parent = new HashMap<>();
  Set<TreeNode> visited = new HashSet<>();
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    this.dfs2(root);
    while (p != null) {
      visited.add(p);
      p = parent.get(p);
    }
    while (q != null) {
      if (visited.contains(q)) {
        return q;
      }
      q = parent.get(q);
    }
    return this.ans;
  }

  /**
   * 把所有节点的父节点都保存下来
   * @param root
   */
  private void dfs2(TreeNode root) {
    if (root.left != null) {
      parent.put(root.left, root);
      dfs2(root.left);
    }

    if(root.right != null) {
      parent.put(root.right, root);
      dfs2(root.right);
    }
  }

  public static void main(String[] args) {
    TreeNode treeNode = TreeNodeUtil.buildTreeNode(new int[]{3,5,1,6,2,0,8,-1,-1,7,4});
    Solution236 solution236 = new Solution236();
    TreeNode result = solution236.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(1));
    System.out.println(result.val);
    System.out.println(solution236.lowestCommonAncestor2(treeNode, new TreeNode(5), new TreeNode(1)).val);
  }
}
