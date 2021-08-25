package com.chehejia.letcode.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/24
 */
public class PoolTest2 {


  private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 5, TimeUnit.SECONDS,
      new LinkedBlockingQueue<>(5), r -> {
        Thread thread = new Thread(r, "testName");
        return thread;
      });

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      executor.execute(() -> {
        System.out.println("......." + Thread.currentThread().getName());
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
  }
}
