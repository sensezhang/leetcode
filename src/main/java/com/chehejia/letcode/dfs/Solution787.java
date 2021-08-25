package com.chehejia.letcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/8/24 8:17 下午
 **/
public class Solution787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            List<int[]> lists = map.getOrDefault(flights[i][0], new ArrayList<>());
            lists.add(new int[]{flights[i][1], flights[i][2]});
        }
        return 0;
    }
}
