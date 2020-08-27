package com.yonyou.letcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/20
 */
public class Solution290 {
  public boolean wordPattern(String pattern, String str) {
    String[] s = str.split(" ");
    if (s.length != pattern.length()) {
      return false;
    }
    Map<Character, String> map = new HashMap<>();
    Set<String> values = new HashSet<>();
    for (int i = 0; i < pattern.length(); i++) {
      Character a = pattern.charAt(i);
      if (map.containsKey(a)) {
        if (!map.get(a).equals(s[i])) {
          return false;
        }
      } else {
        if (values.contains(s[i])) {
          return false;
        }
        values.add(s[i]);
        map.put(a, s[i]);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution290 solution290 = new Solution290();
    boolean a = solution290.wordPattern("abba", "dog cat cat fish");
    System.out.println(a);
  }
}
