package com.chehejia.letcode;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/23
 */
public class Solution641 {

  static class MyCircularDeque{

    private int[] arr;
    private int size;
    private int front;
    private int last;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
      arr = new int[k];
      size = 0;
      front = 0;
      last = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
      if (isFull()) {
        return false;
      }
      if (front == 0) {
        front = arr.length - 1;
      } else {
        front--;
      }
      arr[front] = value;
      size++;
      return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
      if (isFull()) {
        return false;
      }
      arr[last] = value;
      last = last == arr.length -1 ? 0 : last + 1;
      size++;
      return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
      if (isEmpty()) {
        return false;
      }
      front = front == arr.length - 1 ? 0 : front + 1;
      size--;
      return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
      if (isEmpty()) {
        return false;
      }
      last = last == 0 ? arr.length - 1 : last - 1;
      size--;
      return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
      if (isEmpty()) {
        return -1;
      }
      return arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
      if (isEmpty()) {
        return -1;
      }
      return last == 0 ? arr[arr.length - 1] : arr[last-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
      return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
      return arr.length == size;
    }
  }

  public static void main(String[] args) {
    MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
    System.out.println(circularDeque.insertLast(1));			        // 返回 true
    System.out.println(circularDeque.insertLast(2));			        // 返回 true
//    System.out.println(circularDeque.insertFront(3));			        // 返回 true
//    System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
    System.out.println(circularDeque.getRear());  				// 返回 2
    System.out.println(circularDeque.isFull());				        // 返回 true
    System.out.println(circularDeque.deleteLast());			        // 返回 true
    System.out.println(circularDeque.insertFront(4));			        // 返回 true
    System.out.println(circularDeque.getFront());
    System.out.println(circularDeque.insertLast(3));
    System.out.println(circularDeque.getRear());
  }

}
