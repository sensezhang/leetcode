package com.yonyou.letcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/7
 */
public class SempaphoreTest1 {

  private Semaphore semaphore = new Semaphore(0);

  public static void main(String[] args) throws Exception {
    SempaphoreTest1 sempaphoreTest1 = new SempaphoreTest1();
    for (int i = 0; i < 10; i++) {
      sempaphoreTest1.first(() -> {
        System.out.println("aaaaaaaaaaaaaaaa");
      });
      sempaphoreTest1.second(() -> {
        System.out.println("bbbbbbbbbbbbb");
      });
    }

  }

  public void first(Runnable runnable) throws Exception {
    runnable.run();
    semaphore.release();
  }

  public void second (Runnable runnable) throws Exception {
    semaphore.acquire();
    runnable.run();
  }
}
