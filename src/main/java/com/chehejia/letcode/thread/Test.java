package com.chehejia.letcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author zhangwbin
 * @Date 2022/1/12 1:24 下午
 **/
public class Test implements Runnable{

    private static Integer a = 0;

    @Override
    public void run() {
        for (int i = 0;i < 100; i++) {
            a++;
        }
    }

    public static void main(String[] args) {
        new Thread(new Test()).start();
        new Thread(new Test()).start();
        System.out.println(a);
    }
}
