package com.chehejia.letcode.listnode;


/**
 * 数组转链表
 *
 * @Author: zhangwbin
 * @Date: 2020/4/23
 */
public class ListNodeUtil {

  public static ListNode convertArrayToListNode(int[] ints) {
    if (ints == null || ints.length == 0) {
      return null;
    }
    ListNode listNode = new ListNode(ints[0]);
    ListNode tmp = listNode;
    for (int i = 1; i < ints.length; i++) {
      ListNode listNodeOne = new ListNode(ints[i]);
      tmp.next = listNodeOne;
      tmp = tmp.next;
    }
    return listNode;
  }

  public static void printListNode(ListNode listNode) {
    while (listNode != null) {
      System.out.print(listNode.val);
      if (listNode.next != null) {
        System.out.print("->");
      } else {
        System.out.println();
      }
      listNode = listNode.next;
    }
  }

  public static void main(String[] args) {
    ListNode listNode = convertArrayToListNode(new int[]{1, 2, 3, 4, 5});
    printListNode(listNode);
  }
}
