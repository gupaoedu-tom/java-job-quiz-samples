package com.gupaoedu.job.quiz.node01;

public class SingletonTest {

//    public class Singleton {
//        private static Singleton instance;
//        private Singleton (){}
//        public static synchronized Singleton getInstance() {
//            if (instance == null) {
//                instance = new Singleton();
//            }
//            return instance;
//        }
//    }

//    public class Singleton {
//        private volatile static Singleton singleton;
//        private Singleton (){}
//        public static Singleton getInstance() {
//            if (singleton == null) {
//                synchronized(Singleton.class) {
//                    if(singleton == null) {
//                        singleton = new Singleton();
//                    }
//                }
//            }
//            return singleton;
//        }
//    }

//    public class Singleton {
//        private static Singleton instance = new Singleton();
//        private Singleton (){}
//        public static Singleton getInstance() {
//            return instance;
//        }
//    }

//    public class Singleton {
//        private static Singleton instance = null;
//        static {
//            instance = new Singleton();
//        }
//        private Singleton (){}
//        public static Singleton getInstance() {
//            return instance;
//        }
//    }



//    public class Singleton {
//        private static class SingletonHolder {
//            private static final Singleton INSTANCE = new Singleton();
//        }
//        private Singleton (){}
//        public static final Singleton getInstance() {
//            return SingletonHolder.INSTANCE;
//        }
//    }

    public enum Singleton {
        INSTANCE;
        public void doSomeThing( ) {
            //TODO
        }
    }
}
