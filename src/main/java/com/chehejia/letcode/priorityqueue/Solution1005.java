package com.chehejia.letcode.priorityqueue;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/3 3:59 下午
 **/
public class Solution1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.offer(i);
        }
        while (k > 0) {
            int tmp = queue.poll();
            queue.offer(-tmp);
            k--;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ans += queue.poll();
        }
        return ans;
    }
}
