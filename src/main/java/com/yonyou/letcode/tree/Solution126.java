package com.yonyou.letcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return result;
    }
    Map<String, List<String>> wordListMap = new HashMap<>();
    for (int i = 0; i < wordList.size(); i++) {
      for (int j = 0; j < beginWord.length(); j++) {
        String key = wordList.get(i).substring(0, j) + "*" + wordList.get(i).substring(j +1);
        if (wordListMap.containsKey(key)) {
          wordListMap.get(key).add(wordList.get(i));
        } else {
          List<String> list = new ArrayList<>();
          list.add(wordList.get(i));
          wordListMap.put(key, list);
        }
      }
    }
    Deque<String> deque =  new LinkedList<>();
    deque.add(beginWord);
    int level = 1;
    while (!deque.isEmpty()) {

      int size = deque.size();

      for (int i = 0; i < size; i++) {
        String word = deque.pop();
        result.get(level - 1).add(word);
        String key = word.substring(0, i) + "*" + word.substring(i +1);
        if (wordListMap.containsKey(key)) {
          List<String> nextWordList = wordListMap.get(key);
          for (String str : nextWordList) {
            if (!visited.contains(word)) {
              deque.push(str);
            }
          }
        }
      }
      level++;
    }
    return result;
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
