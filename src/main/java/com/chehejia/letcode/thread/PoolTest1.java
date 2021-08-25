package com.chehejia.letcode.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/24
 */
public class PoolTest1 {

  private static ExecutorService executorService = Executors.newSingleThreadExecutor();
  public static void main(String[] args) {
    for(int i = 0; i < 10; i++) {
      int m = i;
      executorService.execute(() -> {
        System.out.println("111111111111111111" + m);
        try {
          TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
    System.out.println("装载完毕。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。放进队列");
    executorService.shutdown();
  }
}
