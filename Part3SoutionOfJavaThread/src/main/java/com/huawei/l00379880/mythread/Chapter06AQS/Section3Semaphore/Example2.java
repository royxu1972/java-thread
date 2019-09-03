package com.huawei.l00379880.mythread.Chapter06AQS.Section3Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***********************************************************
 * @note      : Semaphore可以用于做流量控制，同时获取多个许可证
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/3 20:11
 ***********************************************************/
public class Example2 {
    /**
     * 启动200个线程进行并发读写
     */
    private final static int THREAD_COUNT = 200;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 允许10个线程获取许可证，只有10个数据库连接
        final Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3);
                    System.out.println(threadNum);
                    semaphore.release(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }
}
