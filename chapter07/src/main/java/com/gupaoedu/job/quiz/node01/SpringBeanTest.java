package com.gupaoedu.job.quiz.node01;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SpringBeanTest {

    @Data
    public class Teacher{
        private String name;

    }

    @Data
    public class Student{

        private String name;
        private Teacher teacher;

    }

    @Configuration
    public class BeansConfiguration {
        @Bean
        public Student student(){

            Student student = new Student();
            student.setName("张三");
            student.setTeacher(new Teacher());
            return student;
        }

        @Bean
        public Teacher teacher(){

            Teacher teacher = new Teacher();
            teacher.setName("Tom");
            return teacher;

        }

    }

}
