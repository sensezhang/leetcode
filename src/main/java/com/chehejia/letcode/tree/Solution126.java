
package com.chehejia.letcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/10
 */
public class Solution126 {
  List<List<String>> result = new ArrayList<>();
  Set<String> visited = new HashSet<>();
  Map<String, Set<String>> map = new HashMap<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<String> list = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    transWord(wordSet);
    list.add(beginWord);
    visited.add(beginWord);
    int minpath = bfs(beginWord, endWord);
    dfs(beginWord, endWord, list, minpath);
    return result;
  }

  private void transWord(Set<String> wordList) {
    for (String str : wordList) {
      Set<String> set = new HashSet<>();
      char[] a = str.toCharArray();
      for (int n = 0; n < a.length; n++) {
        char tmpChar = a[n];
        for (int i = 0; i <= 26; i++) {
          a[n] = (char)(i + 'a');
          if (a[n] == tmpChar) {
            continue;
          }
          String endW = new String(a);
          if (wordList.contains(endW)) {
            set.add(endW);
          }
        }
        a[n] = tmpChar;
      }
      map.put(str, set);
    }
  }

  private int bfs(String beginWord, String endWord) {
    int count = 0;
    Set<String> visitedbfs = new HashSet<>();
    Set<String> begins = new HashSet<>();
    begins.add(beginWord);
    visitedbfs.add(beginWord);
    Set<String> ends = new HashSet<>();
    ends.add(endWord);
    while (!begins.isEmpty() && !ends.isEmpty()) {
      if (begins.size() > ends.size()) {
        swap(begins, ends);
      }
      count++;
      Set<String> tmpSet = new HashSet<>();
      for (String str : begins) {
        Set<String> nextList = map.get(str);
        for (String next : nextList) {
          if (ends.contains(next)) {
            return count + 1;
          }
          if (!visitedbfs.contains(next)) {
            tmpSet.add(next);
            visitedbfs.add(next);
          }
        }
      }
      begins = tmpSet;
    }
    return 0;
  }

  private void swap(Set<String> begins, Set<String> ends) {
    Set<String> tmp = begins;
    begins = ends;
    ends = tmp;
  }

  private void dfs(String beginWord, String endWord, List<String> list, int minPath) {
    if (list.size() > minPath) {
      return;
    }
    if (beginWord.equals(endWord)) {
      if (list.size() < minPath) {
        minPath = Math.min(minPath, list.size());
        result.clear();
      }
      if (list.size() <= minPath) {
        result.add(new ArrayList<>(list));
      }
      return;
    }
    Set<String> nextList = map.get(beginWord);
    for (String next : nextList) {
      if (!visited.contains(next)) {
        list.add(next);
        visited.add(next);
        dfs(next, endWord, list, minPath);
        list.remove(next);
        visited.remove(next);
      }
    }
  }


  public static void main(String[] args) {
    Solution126 solution126 = new Solution126();
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
    List<List<String>> result = solution126.findLadders(beginWord, endWord, wordList);
    System.out.println(result);
  }
}
