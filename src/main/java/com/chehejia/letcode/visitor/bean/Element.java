package com.chehejia.letcode.visitor.bean;

import com.chehejia.letcode.visitor.Visitor1;

/**
 * 抽象元素角色，定义了一个accept操作，以visitor作为参数
 * @author zhangwbin
 */
public interface Element {
    /**
     * 接受一个抽象访问者访问
     * @param visitor
     */
    void accept(Visitor1 visitor);
}
