package com.yonyou.letcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/4
 */
public class Solution17 {
  public List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return list;
    }
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    combinations("", list, 0, digits, map);
    return list;
  }
  private void combinations(String s, List<String> result, int level, String digits, Map<Character, String> map){
    // terminator
    if(level == digits.length()) {
      result.add(s);
      return;
    }
    // process
    String letters = map.get(digits.charAt(level));
    for (int j = 0; j < letters.length(); j++) {
      combinations(s+letters.charAt(j), result, level+1, digits, map);
    }
  }

  public static void main(String[] args) {
    Solution17 solution17 = new Solution17();
    List<String> lists = solution17.letterCombinations("23");
    System.out.println(lists);
  }
}
