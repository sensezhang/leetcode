package com.chehejia.letcode.stack;

import java.util.Stack;

class CQueue {

    Stack<Integer> stackInput = null;
    Stack<Integer> stackOutput = null;

    public CQueue() {
        stackInput = new Stack<>();
        stackOutput = new Stack<>();
    }
    
    public void appendTail(int value) {
        stackInput.push(value);
    }
    
    public int deleteHead() {
        if (stackInput.isEmpty() && stackOutput.isEmpty()) {
            return -1;
        }
        if (!stackOutput.isEmpty()) {
            return stackOutput.pop();
        } else {
            while (!stackInput.isEmpty()) {
                stackOutput.push(stackInput.pop());
            }
            return stackOutput.pop();
        }
    }
}
