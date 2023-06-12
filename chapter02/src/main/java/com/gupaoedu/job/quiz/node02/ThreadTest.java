package com.gupaoedu.job.quiz.node02;

import java.util.concurrent.Callable;

public class ThreadTest {

//    public class MyThread extends Thread{
//        public void run(){
//            // to do something
//        }
//    }


//    public class MyThread implements Runnable{
//        public void run(){
//            // to do something
//        }
//    }

    public class MyThread implements Callable<String> {
        public String call() throws Exception{
            // to do something
            return null;
        }
    }

}
