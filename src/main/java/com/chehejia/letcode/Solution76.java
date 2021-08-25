package com.chehejia.letcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/27
 */
public class Solution76 {
  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    Map<Character, Integer> smap = new HashMap<>();
    String result = s;
    if (s == null || t == null || s.length() < t.length()) {
      return "";
    }
    for (int i = 0; i < t.length(); i++) {
      if (map.containsKey(t.charAt(i))) {
        map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
      } else {
        map.put(t.charAt(i), 1);
      }
    }
    int left = 0;
    int right = 0;
    // 找到左指针位置,让右指针指向左指针
    while(left < s.length()) {
      char one = s.charAt(left);
      if (map.containsKey(one)) {
        right = left;
        break;
      }
      left++;
    }
    while (left <= right && right < s.length()) {
      char one = s.charAt(right);
      if (map.containsKey(one)) {
        if (smap.containsKey(one)) {
          smap.put(one, smap.get(one) + 1);
        } else {
          smap.put(one, 1);
        }
        if (checkMap(smap, map)) {
          result = result.length() > right - left + 1? s.substring(left, ++right) : result;
          smap.put(one, smap.get(one) - 1);
          while (++left <= right) {
            if(map.containsKey(s.charAt(left))) {
              break;
            }
          }
        } else {
          right++;
        }
      } else {
        right++;
      }
    }
    return result;
  }

  private boolean checkMap(Map<Character, Integer> smap, Map<Character, Integer> map) {
    Iterator iter = map.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry entry = (Entry) iter.next();
      Character character = (Character) entry.getKey();
      if (smap.getOrDefault(character, 0) < map.get(character)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution76 solution76 = new Solution76();
    String s = solution76.minWindow("a","a");
    System.out.println(s);
  }
}
