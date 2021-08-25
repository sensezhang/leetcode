package com.chehejia.letcode.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangwbin
 * @Date: 2020/8/24
 */
public class ThreadPoolExtend extends ThreadPoolExecutor {

  private final ThreadLocal<Long> localTime = new ThreadLocal<>();

  public ThreadPoolExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime,
      TimeUnit unit,
      BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  public ThreadPoolExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime,
      TimeUnit unit, BlockingQueue<Runnable> workQueue,
      ThreadFactory threadFactory) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
  }

  public ThreadPoolExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime,
      TimeUnit unit, BlockingQueue<Runnable> workQueue,
      RejectedExecutionHandler handler) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
  }

  public ThreadPoolExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime,
      TimeUnit unit, BlockingQueue<Runnable> workQueue,
      ThreadFactory threadFactory, RejectedExecutionHandler handler) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
  }

  @Override
  public void beforeExecute(Thread t, Runnable r) {
    Long time = System.currentTimeMillis();
    localTime.set(time);
    System.out.println("开始执行线程, time :{}" + time);
  }

  @Override
  public void afterExecute(Runnable r, Throwable t){
    Long time = System.currentTimeMillis();
    System.out.println("执行线程结束, time :{}" + time + ", 耗时 ：{}ms" + (time - localTime.get()));
  }

  public static void main(String[] args) {
    ThreadPoolExtend threadPoolExtend = new ThreadPoolExtend(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));

    for (int i = 0; i < 10;)threadPoolExtend.execute(() -> {
      System.out.println();
    });
  }
}
