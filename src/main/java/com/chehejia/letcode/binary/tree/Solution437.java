package com.chehejia.letcode.binary.tree;

import java.util.*;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/9/28 9:06 上午
 **/
public class Solution437 {

    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        dfs(root, targetSum, map, 0);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, Map<Integer, Integer> map, int curSum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        result += map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(root.left, targetSum, map, curSum);
        dfs(root.right, targetSum, map, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }

    public static void main(String[] args) {
        Solution437 solution437 = new Solution437();
        solution437.pathSum(TreeNodeUtil.buildTreeNode(new Integer[]{1,-2,-3}), -3);
    }
}
