package com.chehejia.letcode.visitor.bean;

import com.chehejia.letcode.visitor.Visitor1;

/**
 * 具体元素，允许visitor访问本对象的数据结构
 * @author zhangwbin
 */
public class Student implements Element{

    private String name;
    private int grade;
    private int paperCount;

    @Override
    public void accept(Visitor1 visitor) {
        visitor.visit(this);
    }

    public Student(String name, int grade, int paperCount) {
        this.name = name;
        this.grade = grade;
        this.paperCount = paperCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }
}
