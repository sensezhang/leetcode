package com.yonyou.letcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/7
 */
public class SempaphoreTest {

  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(2);
    for (int i = 0; i < 100; i++) {
      new ByTicketThread("客户" + i, semaphore).start();
    }
  }
}
class ByTicketThread extends Thread{
  private final Semaphore semaphore;

  public ByTicketThread(String s, Semaphore semaphore) {
    this.semaphore = semaphore;
    this.setName(s);
  }


  @Override
  public void run() {
    try {
      semaphore.acquire();
      System.out.println(this.getName() + "正在买票。");
      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
      System.out.println(this.getName() + "买票完成。");
    }
  }
}

