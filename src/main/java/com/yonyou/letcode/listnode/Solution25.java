package com.yonyou.letcode.listnode;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/27
 */
public class Solution25 {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode end = dummy;

    while (end != null) {
      int i = 0;
      while(i < k && end != null) {
        end = end.next;
        i++;
      }
      if (end == null) {
        break;
      }
      ListNode next = end.next;
      ListNode start = pre.next;
      end.next = null;
      pre.next = reverseListNode(start);
      start.next = next;
      pre = start;
      end = pre;
    }
    return dummy.next;
  }

  private ListNode reverseListNode(ListNode listNode) {
    ListNode cur = listNode;
    ListNode pre = null;
    while(cur != null) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    return pre;
  }

  public static void main(String[] args) {
    ListNode head = ListNodeUtil.convertArrayToListNode(new int[]{1,2,3,4,5});
    Solution25 solution25 = new Solution25();
    ListNode result = solution25.reverseKGroup(head, 2);
    ListNodeUtil.printListNode(result);
  }

}
