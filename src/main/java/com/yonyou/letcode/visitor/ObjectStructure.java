package com.yonyou.letcode.visitor;

import com.yonyou.letcode.visitor.bean.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 对象结构，是元素的集合，提供元素的访问入口
 * @Author zhangwbin
 * @Date 2021/4/22 4:31 下午
 **/
public class ObjectStructure {
    // 使用集合保存Element元素，暂时不考虑多线程的问题
    private List<Element> elementList = new ArrayList<>();

    public void accept(Visitor visitor) {
        for (Element element : elementList) {
            element.accept(visitor);
        }
    }

    public void addElement(Element element) {
        elementList.add(element);
    }

    public void removeElement(Element element) {
        elementList.remove(element);
    }
}
