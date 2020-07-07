package com.yonyou.letcode.listnode;

/**
 * 1-2-3-4 + 3-4 = 1-2-6-8
 *
 * @Author: zhangwbin
 * @Date: 2020/7/7
 */
public class SumListNode {


  public ListNode sumListNode(ListNode num1, ListNode num2) {
    // 链表反转
    num1 = reverse1(num1);
    num2 = reverse1(num2);
    // 链表相加
    ListNode root = new ListNode(0);
    ListNode cur = root;
    int nextSum = 0;
    while (num1 != null || num2 != null) {
      int sum = (num1 == null ? 0 : num1.val) + (num2 == null ? 0 : num2.val) + nextSum;
      if (sum >= 10) {
        nextSum = sum / 10;
      }
      ListNode nextNode = new ListNode(sum % 10);
      cur.next = nextNode;
      cur = cur.next;
      num1 = num1 == null ? null : num1.next;
      num2 = num2 == null ? null : num2.next;
    }
    if (nextSum != 0) {
      cur.next = new ListNode(nextSum);
    }
    return reverse1(root.next);
  }


  private ListNode reverse1(ListNode root) {
    if (root == null || root.next == null) {
      return root;
    }
    ListNode pre = reverse1(root.next);
    root.next.next = root;
    root.next = null;
    return pre;
  }

  private ListNode reverse2(ListNode root) {
    ListNode cur = root;
    ListNode head = null;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = head;
      head = cur;
      cur = tmp;
    }
    return head;
  }

  public static void main(String[] args) {
    SumListNode sumListNode = new SumListNode();
    ListNode node = sumListNode
        .sumListNode(ListNodeUtil.convertArrayToListNode(new int[]{9, 9, 7, 4}),
            ListNodeUtil.convertArrayToListNode(new int[]{3, 4}));
    ListNodeUtil.printListNode(node);
  }
}
