package com.chehejia.letcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/28
 */
public class Solution3 {

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    if (s == null || s.length() == 0) {
      return 0;
    }
    int maxLen = Integer.MIN_VALUE;
    int left = 0;
    int right = 1;
    map.put(s.charAt(0), 0);
    while (left < right && right < s.length()) {
      if (!map.containsKey(s.charAt(right))) {
        map.put(s.charAt(right), right);
        right++;
      } else {
        maxLen = Math.max(right - left, maxLen);
        int tmp = map.get(s.charAt(right)) + 1;
        for (int i = left; i < tmp; i++) {
          map.remove(s.charAt(i));
        }
        left = tmp;
        map.put(s.charAt(right), right);
        right++;
      }

    }
    return maxLen == Integer.MIN_VALUE ? s.length() : Math.max(maxLen, right - left);
  }

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    int count = solution3.lengthOfLongestSubstring("abba");
    System.out.println(count);
  }
}
