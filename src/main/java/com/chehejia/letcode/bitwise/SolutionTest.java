package com.chehejia.letcode.bitwise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/5/16 11:30 上午
 **/
public class SolutionTest {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> test(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return list;
    }

    public static void main(String[] args) {
        SolutionTest solutionTest = new SolutionTest();
        solutionTest.test(new int[]{5, 1, 6});
        System.out.println(solutionTest.list);
    }

    private void dfs(int[] nums, List<Integer> list, int index) {
        if (index == list.size()) {
            this.list.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.indexOf(nums[i]));
        }
    }
}
