package com.yonyou.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/28
 */
public class MSolution18 {

  public ListNode deleteNode(ListNode head, int val) {
    if (head.val == val) {
      return head.next;
    }
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
        break;
      }
      cur = cur.next;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode list = ListNodeUtil.convertArrayToListNode(new int[]{4,5,1,9});
    MSolution18 mSolution18 = new MSolution18();
    ListNode head = mSolution18.deleteNode(list, 1);
    ListNodeUtil.printListNode(head);
  }
}
