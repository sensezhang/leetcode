package com.chehejia.letcode.binary.tree;

import java.util.*;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            str.append(node == null ? null : node.val);
            str.append(",");
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        if (str == null || str[0] == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);
        for (int i = 1; i < str.length; i += 2) {
            TreeNode node = queue.poll();
            if (!"null".equals(str[i])) {
                node.left = new TreeNode(Integer.valueOf(str[i]));
                queue.add(node.left);
            }
            if (!"null".equals(str[i + 1])) {
                node.right = new TreeNode(Integer.valueOf(str[i + 1]));
                queue.add(node.right);
            }
        }
        return root;
    }
}