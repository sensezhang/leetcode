package com.yonyou.letcode.visitor.bean;

import com.yonyou.letcode.visitor.Visitor;

/**
 * 具体元素，允许visitor访问本对象的数据结构
 * @author zhangwbin
 */
public class Teacher implements Element{

    private String name;
    private int score;
    private int paperCount;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Teacher(String name, int score, int paperCount){
        this.name = name;
        this.score = score;
        this.paperCount = paperCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }
}
