package com.chehejia.letcode.array;

import java.util.Arrays;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/4/22 10:30 PM
 **/
public class Solution396 {

    public int maxRotateFunction(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += i * nums[i];
        }
        return cur;
    }

}
