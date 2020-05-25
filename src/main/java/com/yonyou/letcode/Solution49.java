package com.yonyou.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/25
 */
public class Solution49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    // 暴力 时间复杂度Knlogn
   /* if(strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i< strs.length; i++) {
      String str = strs[i];
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = Arrays.toString(chars);
      if (map.containsKey(key)) {
        map.get(key).add(str);
      } else {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(key, list);
      }
    }
    return new ArrayList<>(map.values());*/
    // hash计数法,时间复杂度n*k
    if(strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i< strs.length; i++) {
      String str = strs[i];
      char[] chars = str.toCharArray();
      int[] tmp = new int[26];
      for(int j = 0; j < chars.length; j ++) {
        int index = chars[j] - 'a';
        tmp[index]++;
      }
      String key = Arrays.toString(tmp);
      if (map.containsKey(key)) {
        map.get(key).add(str);
      } else {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(key, list);
      }
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    Solution49 solution49 = new Solution49();
    String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> lists = solution49.groupAnagrams(strs);
    System.out.println(lists);

  }
}
