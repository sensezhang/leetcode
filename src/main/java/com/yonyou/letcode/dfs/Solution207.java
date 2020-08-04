package com.yonyou.letcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/4
 */
public class Solution207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      List<Integer> list = map.getOrDefault(prerequisites[i][0], new ArrayList<>());
      list.add(prerequisites[i][1]);
      map.put(prerequisites[i][0], list);

    }
    int[] visited = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      boolean f = dfs(i, visited, map);
      if (!f) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(int i, int[] visited, Map<Integer, List<Integer>> map) {
    if (visited[i] == 1) {
      return false;
    }
    if (visited[i] == -1) {
      return true;
    }
    visited[i] = 1;
    List<Integer> list = map.get(i);
    if (list != null) {
      for (Integer j : list) {
        boolean f = dfs(j, visited, map);
        if (!f) {
          return false;
        }
      }
    }
    visited[i] = -1;
    return true;
  }

  public static void main(String[] args) {
    Solution207 solution207 = new Solution207();
    solution207.canFinish(2, new int[][]{{1, 0}});
  }
}
