package com.gupaoedu.job.quiz.node02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[ ] args ) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        executorService.execute(new Runnable(){
            @Override
            public void run() {
                //开始执行任务
                try {
                    Thread.sleep(3000);//模拟任务执行时间
                    countDownLatch.countDown(); //任务执行结束后，计数器减1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //阻塞main线程|当任务执行结束调用countDown()方法使得计数器归零后，唤醒主线程		countDownLatch.await();
        executorService.shutdown();
    }
}
