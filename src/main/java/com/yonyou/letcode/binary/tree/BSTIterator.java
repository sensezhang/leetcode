package com.yonyou.letcode.binary.tree;

import java.util.LinkedList;

class BSTIterator {

    LinkedList<Integer> queue = null;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        initQueue(root);
    }
    private void initQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        initQueue(root.left);
        queue.offer(root.val);
        initQueue(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.peek() != null;
    }
}