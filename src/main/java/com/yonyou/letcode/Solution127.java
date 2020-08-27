package com.yonyou.letcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/8
 */
public class Solution127 {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    int len = 1;
    int strLen = beginWord.length();
    Set<String> visited = new HashSet<>();

    beginSet.add(beginWord);
    endSet.add(endWord);
    while (!beginSet.isEmpty() && ! endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        Set<String> tmp = beginSet;
        beginSet = endSet;
        endSet = tmp;
      }
       Set<String> tmp = new HashSet<>();
      for (String word : beginSet) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < strLen; i++) {
          // 记录之前的值，为后边回滚做记录
          char old = chs[i];
          for (char c = 'a'; c <= 'z'; c++) {
            chs[i] = c;
            String target = new String(chs);
            if (endSet.contains(target)) {
              return len + 1;
            }
            if (!visited.contains(target) && wordSet.contains(target)) {
              tmp.add(target);
              visited.add(target);
            }
          }
          chs[i] = old;
        }
      }
      len++;
      beginSet = tmp;
    }
    return 0;
  }

  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
    Solution127 solution127 = new Solution127();
    int length = solution127.ladderLength(beginWord, endWord, wordList);
    System.out.println(length);
  }
}
