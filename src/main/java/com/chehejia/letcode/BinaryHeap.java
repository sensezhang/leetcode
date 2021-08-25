package com.chehejia.letcode;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 二叉堆
 *
 * @Author: zhangwbin
 * @Date: 2020/6/1
 */
public class BinaryHeap {

  private static int d = 2;
  private int heapSize;
  private int[] heap;

  public BinaryHeap(int capacity) {
    this.heapSize = 0;
    heap = new int[capacity + 1];
    Arrays.fill(heap, -1);
  }

  public boolean isEmpty() {
    return heapSize == 0;
  }

  public boolean isFull() {
    return heapSize == heap.length;
  }

  private int parent(int i) {
    return (i - 1) / d;
  }

  private int kthChild(int i, int k) {
    return i * d + k;
  }

  public void insert(int x) {
    if (isFull()) {
      throw new NoSuchElementException("Heap is full, No space to insert new element");
    }
    heap[heapSize] = x;
    heapSize++;
    heapifyUp(heapSize - 1);
  }

  private void heapifyUp(int i) {
    int tmp = heap[i];
    System.out.println(parent(i));
    while (i > 0 && heap[parent(i)] < tmp) {
      heap[i] = heap[parent(i)];
      i = parent(i);
    }
    heap[i] = tmp;
  }

  public int delete(int x) {
    if (isEmpty()) {
      throw new NoSuchElementException("Heap is empty");
    }
    int maxElement = heap[x];
    heap[x] = heap[heapSize - 1];
    heapSize--;
    heapifyDown(x);
    return maxElement;
  }

  private void heapifyDown(int i) {
    int children;
    int tmp = heap[i];
    while (kthChild(i, 1) < heapSize) {
      children = maxChildren(i);
      if (heap[children] > tmp) {
        heap[i] = heap[children];
        i = children;
      } else {
        break;
      }
    }
    heap[i] = tmp;
  }

  public void printHeap() {
    System.out.print("nHeap = ");
    for (int i = 0; i < heapSize; i++)
      System.out.print(heap[i] + " ");
    System.out.println();
  }

  public int findMax(){
    if(isEmpty()) {
      throw new NoSuchElementException("Heap is empty.");
    }
    return heap[0];
  }

  private int maxChildren(int i) {
    int left = kthChild(i, 1);
    int right = kthChild(i, 2);
    return heap[left] > heap[right] ? left : right;
  }

  public static void main(String[] args) {
    BinaryHeap maxHeap = new BinaryHeap(10);
    maxHeap.insert(2);
    maxHeap.insert(10);
    maxHeap.insert(4);
    maxHeap.insert(9);
    maxHeap.insert(1);
    maxHeap.insert(7);
    maxHeap.insert(5);
    maxHeap.insert(3);


    maxHeap.printHeap();
    maxHeap.delete(5);
    maxHeap.printHeap();
    maxHeap.delete(2);
    maxHeap.printHeap();
    maxHeap.delete(0);
    maxHeap.printHeap();
  }
}
