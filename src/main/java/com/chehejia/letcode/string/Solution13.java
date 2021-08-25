package com.chehejia.letcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字
 * @Author: zhangwbin
 * @Date: 2020/7/15
 */
public class Solution13 {
  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    char[] str = s.toCharArray();
    int count = 0;
    int index = 0;
    while (index < str.length) {
      char m = str[index];
      if (index < str.length - 1) {
        char n = str[index + 1];
        if ((m == 'I' && (n == 'V' || n == 'X'))
            || (m == 'X' && (n == 'L' || n == 'C'))
            || (m == 'C' && (n == 'D' || n == 'M'))) {
          count += map.get(n) - map.get(m);
          index++;
        } else {
          count += map.get(m);
        }
      } else {
        count += map.get(m);
      }
      index++;
    }
    return count;
  }

  public static void main(String[] args) {
    Solution13 solution13 = new Solution13();
    int coount = solution13.romanToInt("DCXXI");
    System.out.println(coount);
  }
}
