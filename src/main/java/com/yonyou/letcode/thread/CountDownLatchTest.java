package com.yonyou.letcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/7
 */
public class CountDownLatchTest {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch count = new CountDownLatch(3);
    Thread getServer1Status = new GetDataStatusThread("服务器1", count);
    Thread getServer2Status = new GetDataStatusThread("服务器2", count);
    Thread getServer3Status = new GetDataStatusThread("服务器3", count);

    getServer1Status.start();
    getServer2Status.start();
    getServer3Status.start();
    StringBuilder s = new StringBuilder();
    s.append("qqq");
    s.deleteCharAt(s.length() - 1);
    count.await(10L, TimeUnit.SECONDS);
    System.out.println("所有服务器状态获取完成");
  }


}

class GetDataStatusThread extends Thread {
  private final CountDownLatch count;

  public GetDataStatusThread(String theadName, CountDownLatch count) {
    this.setName(theadName);
    this.count = count;
  }

  @Override
  public void run() {
    System.out.println("获取" + this.getName() + "状态成功");
    count.countDown();
  }
}
