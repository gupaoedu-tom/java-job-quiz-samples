package com.gupaoedu.job.quiz.node02;

public class HappensBeforeTest {

    public class StartDemo{

        public StartDemo() {
            int x=10;
            synchronized (this) { //此处自动加锁
                //x是共享变量，初始值=10
                if (this.x < 12) {
                    this.x = 12;
                }
            }//此处自动解锁
        }

        int x = 0;
        public void test(){
            Thread t1 = new Thread(){
                //主线程调用t1.start()之前
                //所有对共享变量的修改，此处皆可见
                //此例中，x==10
            };
            //此处对共享变量x修改
            x = 10;
            //主线程启动子线程
            t1.start();
        }

        public void test2() throws InterruptedException {
            Thread t1 = new Thread(){
                //此处对共享变量x修改
                //x = 100;
            };
            //例如此处对共享变量修改，则这个修改结果对线程t1可见
            //主线程启动子线程
            t1.start();
            t1.join();
            //子线程所有对共享变量的修改，在主线程调用t1.join()之后皆可见
            //此例中，x==100
        }
    }



}
