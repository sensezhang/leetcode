package com.chehejia.letcode;


import java.util.Stack;

/**
 * @Author: zhangwbin
 * @Date: 2020/4/5
 */
public class MinStack {

  int min = Integer.MAX_VALUE;
  /**
   * initialize your data structure here.
   */
  private Stack<Integer> stack;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int x) {
    if (x <= min) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    int top = stack.pop();
    if (top==min) {
      min = stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(0);
    minStack.push(1);
    minStack.push(0);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}
