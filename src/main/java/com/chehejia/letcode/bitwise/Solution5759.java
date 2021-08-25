package com.chehejia.letcode.bitwise;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/5/16 10:46 上午
 **/
public class Solution5759 {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int xorpre, int index) {

        for (int i = index; i < nums.length; i++) {
            int one = xorpre ^ nums[i];
            res += one;
            dfs(nums, one, i + 1);
            xorpre = one ^ nums[i];
        }
    }

    public static void main(String[] args) {
        Solution5759 solution5759 = new Solution5759();
        solution5759.subsetXORSum(new int[]{5, 1, 6});
    }
}
