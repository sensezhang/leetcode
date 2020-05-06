package com.yonyou.letcode;


import java.util.Stack;

/**
 * @Author: zhangwbin
 * @Date: 2020/4/5
 */
public class MinStack {

  /**
   * initialize your data structure here.
   */
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();

  public MinStack() {

  }

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty() || minStack.peek() > x) {
      minStack.push(x);
    }
  }

  public void pop() {
    if (stack.isEmpty()) {
      return;
    }
    Integer top = stack.pop();
    if (!minStack.isEmpty() && top.equals(minStack.peek())) {
      minStack.pop();
    }
  }

  public int top() {
    return stack.isEmpty() ? 0 : stack.peek();
  }

  public int getMin() {
    return minStack.isEmpty() ? 0 : minStack.peek();
  }
}
