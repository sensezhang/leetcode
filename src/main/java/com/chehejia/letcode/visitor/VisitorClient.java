package com.chehejia.letcode.visitor;

import com.chehejia.letcode.visitor.bean.Element;
import com.chehejia.letcode.visitor.bean.Student;
import com.chehejia.letcode.visitor.bean.Teacher;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2021/4/22 4:57 下午
 **/
public class VisitorClient {

    public static void main(String[] args) {
        Element stu1 = new Student("Student Jim", 92, 3);
        Element stu2 = new Student("Student Ana", 89, 1);
        Element t1 = new Teacher("Teacher Mike", 83, 10);
        Element t2 = new Teacher("Teacher Lee", 88, 7);
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.addElement(stu1);
        objectStructure.addElement(stu2);
        objectStructure.addElement(t1);
        objectStructure.addElement(t2);
        Visitor1 grandeSelection = new GradeSelection();
        objectStructure.accept(grandeSelection);
        System.out.println("--------结构不变，操作易变------");
        Visitor1 researcherSelection = new ResearcherSelection();
        objectStructure.accept(researcherSelection);
    }
}
