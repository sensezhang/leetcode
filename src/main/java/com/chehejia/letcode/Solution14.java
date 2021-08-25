package com.chehejia.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/6/15
 */
public class Solution14 {

  /**
   * 暴力求解 纵向扫描
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    StringBuilder sb = new StringBuilder();
    if (strs == null || strs.length == 0) {
      return sb.toString();
    }
    int i = 0;
    char one = 0;
    while (true) {
      for (int j = 0; j < strs.length; j++) {
        if (i >= strs[j].length()) {
          return sb.toString();
        }
        char a = strs[j].charAt(i);
        if (j == 0) {
          one = a;
        } else {
          if (one != a) {
            return sb.toString();
          }
        }
        if (j == strs.length - 1) {
          i++;
          sb.append(one);
        }
      }
    }
  }

  /**
   * 暴力求解 纵向扫描优化版
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    for (int i = 0; i < strs[0].length(); i++) {
      char one = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != one) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }

  /**
   * 暴力求解 横向扫描优化版
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String profix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      int length = Math.min(profix.length(), strs[i].length());
      int index = 0;
      while (index < length && profix.charAt(index) == strs[i].charAt(index)) {
        index++;
      }
      profix = profix.substring(0, index);
    }
    return profix;
  }

  /**
   * 分治
   * @param strs
   * @return
   */
  public String longestCommonPrefix3(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    } else {
      return longestCommonPrefix(strs, 0, strs.length - 1);
    }
  }

  private String longestCommonPrefix(String[] strs, int start, int end) {
    if (start == end) {
      return strs[start];
    } else {
      int mid = (end + start) / 2 + start;
      String lcpLeft = longestCommonPrefix(strs, start, mid);
      String lcpRight = longestCommonPrefix(strs, mid + 1, end);
      return commonPrefix(lcpLeft, lcpRight);
    }
  }

  private String commonPrefix(String lcpLeft, String lcpRight) {
    int minLenght = Math.min(lcpLeft.length(), lcpRight.length());
    for (int i = 0; i < minLenght; i++) {
      if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
        return lcpLeft.substring(0, i);
      }
    }
    return lcpLeft.substring(0, minLenght);
  }

  public static void main(String[] args) {
    Solution14 solution14 = new Solution14();
    String[] strs = new String[]{"flower", "flow", "flight"};
    String str = solution14.longestCommonPrefix3(strs);
    System.out.println(str);
  }
}
