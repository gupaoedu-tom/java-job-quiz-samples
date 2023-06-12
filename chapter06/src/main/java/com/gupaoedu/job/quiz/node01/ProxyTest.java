package com.gupaoedu.job.quiz.node01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ProxyTest {

    public interface IHelloService{
        String say();
    }

    private static Object proxy;
    private static Method method;
    private static Object[] args1;

    public static class ProxyExample {

        public static void main(String[] args) {

            //将代理对象的class文件写入磁盘

            System.getProperties().put("sun.misc.ProxyGenerator. saveGeneratedFiles","true");
            IHelloService helloService = (IHelloService) Proxy.newProxyInstance
                    (IHelloService.class.getClassLoader(),
                            new Class[]{IHelloService.class},(proxy,method,args1) -> {
                System.out.println("动态代理执行的逻辑");
                return "Hello world" ;
            });
            System.out.println(helloService.say());
        }
    }
}
