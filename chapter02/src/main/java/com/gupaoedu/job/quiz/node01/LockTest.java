package com.gupaoedu.job.quiz.node01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    Lock lock = new ReentrantLock();
    public void sync(){
        lock.lock(); //添加锁
        //TODO线程安全的代码
        lock.unlock(); //释放锁
    }
}
