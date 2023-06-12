package com.gupaoedu.job.quiz.node02;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class AutowiredAndResourceTest {

//    public class Service {
//
//        // 构造方法注入
//        @Autowired
//        public Service(Service service) {
//            this.service = service;
//        }
//
//        // 成员变量注入
//        @Autowired
//        private Service service;
//
//        // 方法参数注入
//        @Autowired
//        public void setService(Service service) {
//            this.service = service;
//
//        }
//    }


    public class Service {

        @Resource(name = "service1")
        private Service service1;

        @Resource(name = "service2")
        private Service service2;


        @Resource
        private Service service3;

        @Resource
        private Service service4;

    }

}
