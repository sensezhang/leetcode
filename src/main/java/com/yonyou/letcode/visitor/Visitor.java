package com.yonyou.letcode.visitor;

import com.yonyou.letcode.visitor.bean.Student;
import com.yonyou.letcode.visitor.bean.Teacher;

/**
 * 抽象访问者，为该对象结构中具体元素生命一个访问操作接口
 */
public interface Visitor {
    void visit(Student element);

    void visit(Teacher element);
}
