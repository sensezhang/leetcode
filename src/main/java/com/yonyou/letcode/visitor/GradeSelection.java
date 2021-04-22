package com.yonyou.letcode.visitor;

import com.yonyou.letcode.visitor.bean.Student;
import com.yonyou.letcode.visitor.bean.Teacher;

/**
 * @Author zhangwbin
 * @Description 具体的访问者，实现了Visitor中定义的操作
 * @Date 4:25 下午 2021/4/22
 **/
public class GradeSelection implements Visitor{

    private String awardWords = "[%s]的分数是%d，荣获了成绩优秀奖。";

    @Override
    public void visit(Student element) {
        if (element.getGrade() >= 90) {
            System.out.println(String.format(awardWords, element.getName(), element.getGrade()));
        }
    }

    @Override
    public void visit(Teacher element) {
        if (element.getScore() >= 85) {
            System.out.println(String.format(awardWords, element.getName(), element.getScore()));
        }
    }
}
