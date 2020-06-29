package com.yonyou.letcode.listnode;

/**
 * 合并两个有序链表
 * 2
 *
 * @Author: zhangwbin
 * @Date: 2020/5/19
 */
public class Solution21 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
   /* // 递归,时间复杂度O(m+n),空间复杂度O(m+n)
    if (l1==null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }*/
    // 迭代 时间复杂度O(m+n) 空间复杂度O(1)
//    ListNode preHead = new ListNode(0);
//    ListNode tmp = preHead;
//    while (l1 != null && l2 != null) {
//      if (l1.val < l2.val) {
//        tmp.next = l1;
//        l1 = l1.next;
//      } else {
//        tmp.next = l2;
//        l2 = l2.next;
//      }
//      tmp = tmp.next;
//    }
//    tmp.next = l1 == null ? l2 : l1;
//    return preHead.next;

    ListNode pre = new ListNode(0);
    ListNode tmp = pre;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        tmp.next = l1;
        l1 = l1.next;
      } else {
        tmp.next = l2;
        l2 = l2.next;
      }
      tmp = tmp.next;
    }
    tmp.next = l1 == null ? l2 : l1;
    return pre.next;
  }

  public static void main(String[] args) {
    Solution21 solution21 = new Solution21();
    ListNode l1 = ListNodeUtil.convertArrayToListNode(new int[]{1, 2, 4});
    ListNode l2 = ListNodeUtil.convertArrayToListNode(new int[]{1, 3, 4});
    ListNode result = solution21.mergeTwoLists(l1, l2);
    ListNodeUtil.printListNode(result);
  }
}
