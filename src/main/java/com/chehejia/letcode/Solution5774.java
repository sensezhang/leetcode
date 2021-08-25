package com.chehejia.letcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/5/30 11:04 上午
 **/
public class Solution5774 {

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] times = new int[servers.length];
        int cur = 0;
        int[] ans = new int[tasks.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < servers.length; i++) {
            map.put(i, servers[i]);
        }

        // 优先找服务器权重最小的，权重相等找下标最小的
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(servers.length, (o1, o2) -> {
            if (o1.getValue().intValue() == o2.getValue().intValue()) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue() - o2.getValue();
        });
        for (Map.Entry entry : map.entrySet()) {
            queue.add(entry);
        }
       return ans;
    }

    private void set(PriorityQueue<Map.Entry<Integer, Integer>> queue, int[] times, int[] ans, int i) {
        if (queue.isEmpty()) {
            return;
        }
        Map.Entry<Integer, Integer> entry = queue.poll();
        int server = entry.getValue();
        if (times[entry.getKey()] <= i) {
            ans[i] = server;
        } else {
            set(queue, times, ans, i);
        }
        queue.add(entry);

    }
}
