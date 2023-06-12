package com.gupaoedu.job.quiz.node01;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TransactionalTest {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodA(){
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodB(){
        methodA();
    }

}
