package com.yonyou.letcode.listnode;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/26
 */
public class MSolution02_01 {

  public ListNode removeDuplicateNodes(ListNode head) {
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    while (head!=null) {
      set.add(head.val);
      head = head.next;
    }
    ListNode listNode =  new ListNode(0);
    ListNode tmp = listNode;
    Iterator<Integer> it = set.iterator();
    while (it.hasNext()) {
      ListNode node = new ListNode(it.next());
      tmp.next = node;
      tmp = tmp.next;
    }
    return listNode.next;
  }
}
