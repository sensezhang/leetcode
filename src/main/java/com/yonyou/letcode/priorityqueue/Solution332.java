package com.yonyou.letcode.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/27
 */
public class Solution332 {
  Map<String, PriorityQueue<String>> map = new HashMap<>();
  LinkedList<String> results = new LinkedList<>();
  public List<String> findItinerary(List<List<String>> tickets) {
    for (List<String> list : tickets) {
      PriorityQueue<String> queue = map.getOrDefault(list.get(0), new PriorityQueue<>());
      queue.add(list.get(1));
      map.put(list.get(0), queue);
    }
    dfs("JFK");
    Collections.reverse(results);
    return results;
  }

  private void dfs(String from) {
    PriorityQueue<String> queue = map.get(from);
    while (queue != null && !queue.isEmpty()) {
      String to = queue.poll();
      dfs(to);
    }
    results.add(from);
  }
  // [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
  public static void main(String[] args) {
    Solution332 solution332 = new Solution332();
    List<List<String>> lists = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    list1.add("MUC");
    list1.add("LHR");
    lists.add(list1);
    List<String> list2 = new ArrayList<>();
    list2.add("JFK");
    list2.add("MUC");
    lists.add(list2);
    List<String> list3 = new ArrayList<>();
    list3.add("SFO");
    list3.add("SJC");
    lists.add(list3);
    List<String> list4 = new ArrayList<>();
    list4.add("LHR");
    list4.add("SFO");
    lists.add(list4);
    List<String> list11= solution332.findItinerary(lists);
    System.out.println(list11);
  }
}
