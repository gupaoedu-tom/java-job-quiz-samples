package com.gupaoedu.job.quiz.node03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastTest {

    public static void main( String[] args ) {
        Map<String,String> empName = new HashMap<String,String>();
        empName.put("name","mic");
        empName.put("sex","male");
        empName.put("age","18");
        Iterator iterator = empName. keySet().iterator();
        while(iterator.hasNext()) {
            System.out.println(empName.get(iterator.next()));
            empName.put("work","Java") ;
        }
    }

}
