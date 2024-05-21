package com.chehejia.letcode.array;

import java.util.*;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/4/25 9:00 AM
 **/
public class Solution389 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    public Solution389(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> lists = map.getOrDefault(nums[i], new ArrayList<>());
            lists.add(i);
            map.put(nums[i], lists);
        }
    }

    public int pick(int target) {
        List<Integer> lists = map.get(target);
        int index = new Random().nextInt(lists.size());
        return lists.get(index);
    }

    public static void main(String[] args) {
        Solution389 solution389 = new Solution389(new int[]{1,2,3,3,3});
        solution389.pick(3);
    }
}
