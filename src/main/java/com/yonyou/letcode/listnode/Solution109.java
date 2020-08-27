package com.yonyou.letcode.listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/18
 */
public class Solution109 {
  public TreeNode sortedListToBST(ListNode head) {
    List<Integer> lists = new ArrayList<>();
    while (head != null) {
      lists.add(head.val);
      head = head.next;
    }
    Integer[] a = lists.toArray(new Integer[]{});
    return helper(a, 0, a.length - 1);
  }

  private TreeNode helper(Integer[] arr, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right)/2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = helper(arr, left, mid - 1);
    node.right = helper(arr, mid + 1, right);
    return node;
  }

  public static void main(String[] args) {
    Solution109 solution109 = new Solution109();
    solution109.sortedListToBST(ListNodeUtil.convertArrayToListNode(new int[]{-10, -3, 0, 5, 9}));
  }
}
 class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

