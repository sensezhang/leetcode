package com.yonyou.letcode.thread;//semaphore没用过。。。参考

import java.util.concurrent.Semaphore;

/**
 * Created by huali on 2018/7/25.
 */
public class PrintABCRotationUsingSemaphore {
    public static void main(String[] args) {

    }
}

class PrintABCUsingSemaphore {
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);
    //private int attempts = 0;


    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    private void print(String name, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        for (int i = 0; i < 10; ) {
            try {
                currentSemaphore.acquire();
                //System.out.println(Thread.currentThread().getName()+" try to print "+name+", attempts : "+(++attempts));
                System.out.println(Thread.currentThread().getName() +" print "+ name);
                i++;
                nextSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
