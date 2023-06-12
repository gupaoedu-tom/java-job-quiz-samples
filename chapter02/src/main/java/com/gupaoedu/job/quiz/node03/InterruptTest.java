package com.gupaoedu.job.quiz.node03;

public class InterruptTest {


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable(){
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("线程被中断了");
                        return;
                    } else {
                        System.out.println("线程没有被中断");
                    }
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
        Thread.sleep(500);
        t.interrupt();
        System.out.println("线程中断了，程序到这里了");
    }


}
