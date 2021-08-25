package com.chehejia.letcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/7/29
 */
public class SolutionLCP13 {

  int[] dx = new int[]{0, 0, 1, -1};
  int[] dy = new int[]{1, -1, 0, 0};
  int n = 0;
  int m = 0;

  public int minimalSteps(String[] maze) {
    n = maze.length;
    m = maze[0].length();
    int sx = -1;
    int sy = -1;
    int tx = -1;
    int ty = -1;
    List<int[]> buttons = new ArrayList<>();
    List<int[]> stones = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 起点
        if (maze[i].charAt(j) == 'S') {
          sx = i;
          sy = j;
        }
        // 终点
        if (maze[i].charAt(j) == 'T') {
          tx = i;
          ty = j;
        }
        // 保存石头
        if (maze[i].charAt(j) == 'O') {
          stones.add(new int[]{i, j});
        }
        // 保存机关
        if (maze[i].charAt(j) == 'M') {
          buttons.add(new int[]{i, j});
        }
      }
    }
    // bfs 设置起点到各个点的距离
    int[][] startDist = bfs(maze, sx, sy);
    // 如果没有机关，返回起点到终点的距离
    if (buttons.size() == 0) {
      return startDist[tx][ty];
    }
    int nb = buttons.size();
    int ns = stones.size();
    // 从某个机关出发， 到其它机关或起点，或终点的最短距离, nb代表机关的数量，整个二维数组代表，第几个机关到第几个机关之间的距离
    int[][] dist = new int[nb][nb + 2];
    for (int i = 0; i < nb; i++) {
      Arrays.fill(dist[i], -1);
    }
    // 中间结果
    int[][][] dd = new int[nb][][];
    for (int i = 0; i < nb; i++) {
      int[][] d = bfs(maze, buttons.get(i)[0], buttons.get(i)[1]);
      dd[i] = d;
      // 从某个点到终点不需要拿石头
      dist[i][nb + 1] = d[tx][ty];
    }
    // 枚举所有的机关，并填充所有的机关，找到最小步数
    for (int i = 0; i < nb; i++) {
      int tmp = -1;
      for (int k = 0; k < ns; k++) {
        int midX = stones.get(k)[0], midY = stones.get(k)[1];
        if (dd[i][midX][midY] != -1 && startDist[midX][midY] != -1) {
          if (tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY]) {
            tmp = dd[i][midX][midY] + startDist[midX][midY];
          }
        }
      }
      dist[i][nb] = tmp;
      for (int j = i + 1; j < nb; j++) {
        int mn = -1;
        for (int k = 0; k < ns; k++) {
          int midx = stones.get(k)[0], midY = stones.get(k)[1];
          if (dd[i][midx][midY] != -1 && dd[j][midx][midY] != -1) {
            // 计算最小步数
            if (mn == -1 || mn > dd[i][midx][midY] + dd[j][midx][midY]) {
              mn = dd[i][midx][midY] + dd[j][midx][midY];
            }
          }
        }
        dist[i][j] = mn;
        dist[j][i] = mn;
      }
    }

    // 无法到达的情况 (某个机关无法到达起点，或者某个机关无法到达终点)
    for (int i = 0; i < nb; i++) {
      if (dist[i][nb] == -1 || dist[i][nb + 1] == -1) {
        return -1;
      }
    }
    // -1 代表没有遍历到
    // dp 数组， -1 代表没有遍历到
    int[][] dps = new int[1 << nb][nb];
    for (int i = 0; i < 1 << nb; i++) {
      Arrays.fill(dps[i], -1);
    }
    for (int i = 0; i < nb; i++) {
      dps[1 << i][i] = dist[i][nb];
    }

    // 由于更新的状态都比未更新的大，所以直接从小到大遍历即可
    for (int mask = 1; mask < (1 << nb); mask++) {
      for (int i = 0; i < nb; i++) {
        // 当前 dp 是合法的
        if ((mask & (1 << i)) != 0) {
          for (int j = 0; j < nb; j++) {
            // j 不在 mask 里
            if ((mask & (1 << j)) == 0) {
              int next = mask | (1 << j);
              if (dps[next][j] == -1 || dps[next][j] > dps[mask][i] + dist[i][j]) {
                dps[next][j] = dps[mask][i] + dist[i][j];
              }
            }
          }
        }
      }
    }

    int ret = -1;
    int finalMask = (1 << nb) - 1;
    for (int i = 0; i < nb; i++) {
      if (ret == -1 || ret > dps[finalMask][i] + dist[i][nb + 1]) {
        ret = dps[finalMask][i] + dist[i][nb + 1];
      }
    }
    return ret;

  }

  // 获取某个点到各个点的位置
  private int[][] bfs(String[] maze, int x, int y) {
    LinkedList<int[]> queue = new LinkedList<>();
    int[][] results = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(results[i], -1);
    }
    queue.offer(new int[]{x, y});
    results[x][y] = 0;
    while (!queue.isEmpty()) {
      int[] sta = queue.poll();
      int kx = sta[0];
      int ky = sta[1];
      for (int i = 0; i < 4; i++) {
        int lx = kx + dx[i];
        int ly = ky + dy[i];
        // 如果新坐标在迷宫内，并且新坐标不是墙，并且新坐标 == -1
        if (inbound(lx, ly) && maze[lx].charAt(ly) != '#' && results[lx][ly] == -1) {
          results[lx][ly] = results[kx][ky] + 1;
          queue.add(new int[]{lx, ly});
        }
      }
    }
    return results;
  }

  private boolean inbound(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
