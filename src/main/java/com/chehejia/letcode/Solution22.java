package com.chehejia.letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @Author: zhangwbin
 * @Date: 2020/6/10
 */
public class Solution22 {

  List<String> result = new ArrayList<>();
  public List<String> generateParenthesis(int n) {
    if (n!=0) {
      StringBuilder stringBuilder = new StringBuilder("(");
      dfs(n - 1, n, stringBuilder);
    }
    return result;
  }

  private void dfs(int left, int right, StringBuilder stringBuilder) {
    if (left == 0 && right == 0) {
      result.add(stringBuilder.toString());
    }
    if (left > 0) {
      stringBuilder.append("(");
      dfs(left - 1, right, stringBuilder);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
    if (right > left) {
      stringBuilder.append(")");
      dfs(left, right - 1, stringBuilder);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
  }

  public static void main(String[] args) {
    Solution22 solution22 = new Solution22();
    List<String> result = solution22.generateParenthesis(1);
    System.out.println(result);
  }
}
