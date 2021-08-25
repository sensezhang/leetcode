package com.chehejia.letcode.string;

import java.util.HashMap;

/**
 * 异位词
 *
 * @Author: zhangwbin
 * @Date: 2020/5/25
 */
public class Solution242 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    // 暴力求解 时间复杂度nlogn
    /*char[] a = s.toCharArray();
    char[] b = t.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a, b);*/
    // hash
    HashMap<Character, Integer> map = new HashMap();
    char[] a = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(a[i])) {
        map.put(a[i], map.get(a[i]) + 1);
      } else {
        map.put(a[i], 1);
      }
    }
    char[] b = t.toCharArray();
    for (int i = 0; i < t.length(); i++) {
      if (map.containsKey(b[i])) {
        map.put(a[i], map.get(a[i]) - 1);
      } else {
        return false;
      }
      if (map.get(a[i]) == 0) {
        map.remove(a[i]);
      }
    }
    return map.size() == 0;
  }

  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    Solution242 solution242 = new Solution242();
    System.out.println(solution242.isAnagram(s, t));
    s = "rat";
    t = "car";
    System.out.println(solution242.isAnagram(s, t));

  }
}
