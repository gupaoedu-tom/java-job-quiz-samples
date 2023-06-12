package com.gupaoedu.job.quiz.node01;

import sun.misc.Unsafe;

public class CasExample02 {
    public static class Example {
        private volatile int state=0;
        private static final Unsafe unsafe = Unsafe.getUnsafe();
        private static final long stateOffset;
        static {
            try {
                stateOffset = unsafe.objectFieldOffset
                        (Example.class.getDeclaredField("state"));
            } catch (Exception ex) {
                throw new Error( ex ) ;
            }
        }

        public void doSomething( ){
            if(unsafe.compareAndSwapInt(this,stateOffset,0,1)){
                //TODO
            }
        }
    }
}
