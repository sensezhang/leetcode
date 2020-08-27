package com.yonyou.letcode.listnode;

import java.util.Stack;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/20
 */
public class Solution147 {
  public ListNode insertionSortList(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode cur = head;
    while(cur != null) {
      if (stack.isEmpty() || cur.val > stack.peek().val) {
        stack.push(cur);
      } else {
        ListNode tmp = stack.pop();
        if (tmp.val > cur.val) {
          ListNode nx = cur.next;
          cur.next = tmp;
          tmp.next = nx;
          if (!stack.isEmpty()) {
            stack.peek().next = cur;
          }
        }
      }

      cur = cur.next;
    }
    return head;
  }

  public static void main(String[] args) {
    Solution147 solution147 = new Solution147();
    solution147.insertionSortList(ListNodeUtil.convertArrayToListNode(new int[]{4,2,1,3}));
  }
}
