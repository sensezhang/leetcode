package com.chehejia.letcode.array;

import com.chehejia.letcode.Solution1154;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/12/29 8:53 下午
 **/
public class Solution1995 {

    public int countQuadruplets(int[] nums) {
        int ans = 0;
        int len = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> lists = map.getOrDefault(nums[i], new ArrayList<>());
            lists.add(i);
            map.put(nums[i], lists);
        }
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                for (int k = j + 1; k < len - 1; k++) {
                    if (map.containsKey(nums[i]+nums[j] + nums[k])) {
                        List<Integer> lists = map.get(nums[i]+nums[j] + nums[k]);
                        for (Integer m : lists) {
                            if (m > k) {
                                ans++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1995 solution1995 = new Solution1995();
        solution1995.countQuadruplets(new int[]{1,2,3,6});
    }
}
