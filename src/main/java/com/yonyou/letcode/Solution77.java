package com.yonyou.letcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/6
 */
public class Solution77 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    if (n < 1 || k < 1) {
      return result;
    }

    recur(1, k, n, new LinkedList<>());
    return result;
  }

  public void recur(int level, int k, int n, Deque<Integer> deque) {
    if (deque.size() == k) {
      result.add(new ArrayList<>(deque));
      return;
    }
    for (int i = level; i <= n; i++) {
      deque.add(i);
      recur(i + 1, k, n, deque);
      deque.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution77 solution77 = new Solution77();
    List<List<Integer>> result = solution77.combine(4, 2);
    System.out.println(result);
  }
}
