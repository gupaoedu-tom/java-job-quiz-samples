package com.gupaoedu.job.quiz.node01;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class AsyncTest {

//    @EnableAsync//启用异步支持
//    @Configuration
//    public class AppConfig {
//    }


    @Async
    void doSomething() {
        // this will be run asynchronously
    }

    @Async
    void doSomething(String s) {
        // this will be run asynchronously
    }

    @Async
    Future<String> returnSomething(int i) {
        // this will be run asynchronously
        return null;
    }


    public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler{
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {

        }
    }

//    @Configuration
//    @EnableAsync
//    public class AppConfig implements AsyncConfigurer {
//
//        @Override
//        public Executor getAsyncExecutor() {
//            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//            executor.setCorePoolSize(7);
//            executor.setMaxPoolSize(42);
//            executor.setQueueCapacity(11);
//            executor.setThreadNamePrefix("MyExecutor-");
//            executor.initialize();//手动初始化
//            return executor;
//        }


//
//        @Override
//        public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//            return new MyAsyncUncaughtExceptionHandler();
//        }
//    }



    @Configuration
    @EnableAsync
    public class AppConfig implements AsyncConfigurer {

        @Bean
        @Override
        public Executor getAsyncExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(7);
            executor.setMaxPoolSize(42);
            executor.setQueueCapacity(11);
            executor.setThreadNamePrefix("MyExecutor-");
            //executor.initialize();//不用手动调用
            return executor;
        }

        @Override
        public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
            return new MyAsyncUncaughtExceptionHandler();
        }
    }

}
