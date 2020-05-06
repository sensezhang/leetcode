package com.yonyou.letcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhangwbin
 * @Date: 2020/3/30
 */
public class MergeListNode {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val > l2.val) {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    } else {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    }
  }

  public static String[] uncommonFromSentences(String A, String B) {
    String[] str = (A + " " + B).split(" ");
    Set<String> set = new HashSet();
    Set<String> no = new HashSet();
    for (int i = 0; i < str.length; i++) {
      boolean has = false;
      if (set.contains(str[i])) {
        continue;
      }
      for (int j = i + 1; j < str.length; j++) {
        if (str[i].equals(str[j])) {
          has = true;
          set.add(str[i]);
          break;
        }
      }
      if (!has) {
        no.add(str[i]);
      }
    }
    return no.toArray(new String[]{});
  }

  public static void main(String[] args) {
//    ListNode l1 = new ListNode(1);
//    ListNode l3 = new ListNode(2);
//    l3.next = new ListNode(4);
//    l1.next = l3;
//    ListNode l2 = new ListNode(1);
//    ListNode l4 = new ListNode(3);
//    l4.next = new ListNode(4);
//    l2.next = l4;
//
//    ListNode l5 = mergeTwoLists(l1, l2);
//    while (l5 != null) {
//      System.out.println(l5.val);
//      l5 = l5.next;
//    }

    uncommonFromSentences("this apple is sweet", "this apple is sour");
  }
}
