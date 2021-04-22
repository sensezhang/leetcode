package com.yonyou.letcode.visitor;

import com.yonyou.letcode.visitor.bean.Student;
import com.yonyou.letcode.visitor.bean.Teacher;

/**
 * @Description 具体的访问者，实现了Visitor中定义的操作
 * @Author zhangwbin
 * @Date 2021/4/22 4:28 下午
 **/
public class ResearcherSelection implements Visitor{

    private String awardWords = "[%s]的论文数是%d，荣获了科研优秀奖";

    @Override
    public void visit(Student element) {
        if (element.getPaperCount() > 2) {
            System.out.println(String.format(awardWords, element.getName(), element.getPaperCount()));
        }
    }

    @Override
    public void visit(Teacher element) {
        if (element.getPaperCount() > 8) {
            System.out.println(String.format(awardWords, element.getName(), element.getPaperCount()));
        }
    }
}
