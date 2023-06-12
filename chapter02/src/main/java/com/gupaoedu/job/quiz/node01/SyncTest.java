package com.gupaoedu.job.quiz.node01;

public class SyncTest {

    Object lock = new Object();
    //控制代码块
    public void sync(){
        synchronized(lock){

        }
    }

}
