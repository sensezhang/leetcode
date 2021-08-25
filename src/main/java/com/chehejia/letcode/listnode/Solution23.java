package com.chehejia.letcode.listnode;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/17
 */
public class Solution23 {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = new ListNode(0);
    ListNode cur = head;
    while (true) {
      int minIndex = -1;
      ListNode minNode = null;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] == null) {
          continue;
        }
        if (minNode == null || minNode.val > lists[i].val) {
          minNode = lists[i];
          minIndex = i;
        }
      }
      if (minIndex == -1) {
        break;
      }
      cur.next = new ListNode(minNode.val);
      lists[minIndex] = lists[minIndex].next;
      cur = cur.next;
    }
    return head.next;
  }

  public static void main(String[] args) {
    Solution23 solution23 = new Solution23();
    ListNode node1 = ListNodeUtil.convertArrayToListNode(new int[]{1, 4, 5});
    ListNode node2 = ListNodeUtil.convertArrayToListNode(new int[]{1, 3, 4});
    ListNode node3 = ListNodeUtil.convertArrayToListNode(new int[]{2, 6});
    ListNode node4 = solution23.mergeKLists(new ListNode[]{node1, node2, node3});
    ListNodeUtil.printListNode(node4);
  }
}
