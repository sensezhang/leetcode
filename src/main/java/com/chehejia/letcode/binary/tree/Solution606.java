package com.chehejia.letcode.binary.tree;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/3/19 8:21 PM
 **/
public class Solution606 {

    String s = "";
    public String tree2str(TreeNode root) {
        s += root.val;
        if (root.left == null && root.right == null) {
            return s += String.valueOf(root.val);
        } else if (root.left == null) {
            return s += "()("+ tree2str(root.right) +")";
        } else if (root.right == null) {
            return s += "(" + tree2str(root.left) + ")";
        } else {
            return s += "(" + tree2str(root.left) +")(" + tree2str(root.right) + ")";
        }
    }
}
