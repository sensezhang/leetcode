package com.yonyou.letcode.listnode;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/19
 */
public class Main {

  public ListNode getCircle(ListNode head) {
    ListNode low = head;
    ListNode quick = head;
    boolean tmp = true;
    while (quick != null  && quick.next != null && (tmp || low != quick)) {
      low = low.next;
      quick = quick.next.next;
      tmp = false;
    }
    if (low == quick) {
      ListNode circle = head;
      while (circle != quick) {
        circle = circle.next;
        quick = quick.next;
      }
      return circle;
    }
    return head;
  }
}
