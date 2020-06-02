package com.yonyou.letcode;

import java.util.List;

/**
 * @Author: zhangwbin
 * @Date: 2020/5/29
 */
public class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}