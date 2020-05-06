package com.yonyou.letcode;

/**
 * 链表反转
 *
 * @Author: zhangwbin
 * @Date: 2020/4/23
 */
public class Solution206 {

  /**
   * 递归
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return cur;
  }

  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode first = null;
    while (head != null) {
      ListNode nn = head.next;
      ListNode tmp = head;
      tmp.next = first;
      first = tmp;
      head = nn;
    }
    return first;
  }

  public static void main(String[] args) {
    ListNode listNode = ListNodeUtil.convertArrayToListNode(new int[]{1, 2, 3, 4, 5});
    Solution206 solution206 = new Solution206();
    listNode = solution206.reverseList(listNode);
    ListNodeUtil.printListNode(listNode);
    listNode = solution206.reverseList2(listNode);
    ListNodeUtil.printListNode(listNode);
  }
}
