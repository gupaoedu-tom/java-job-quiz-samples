package com.gupaoedu.job.quiz.node01;

public class ReentrantLockTest {

    public static synchronized void lock1(){

        //Thread X 获得了lock1()中的synchronized锁
//再次调用另外一个加同步锁的lock2()方法
        lock2();

    }

    public static synchronized void lock2(){
        //TODO
    }

}
