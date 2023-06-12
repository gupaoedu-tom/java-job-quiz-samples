package com.gupaoedu.job.quiz.node03;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeTest {

    public static void main( String[ ] args ) {
        CopyOnWriteArrayList<Integer> list
                = new CopyOnWriteArrayList<>(new Integer[] {1,7,9,11});
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Integer i = (Integer)itr.next();
            System.out.println(i) ;
            if (i == 7)  list.add(15); //在fail-safe模式下，这里不会被打印
        }
    }
}
