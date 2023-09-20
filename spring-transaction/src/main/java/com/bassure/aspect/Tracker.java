package com.bassure.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Tracker {

    @Pointcut("within(com.bassure.service.*) || within(com.bassure.dao.*)")  // which are the method to track
    public void logMethodPointCut() {

    }

    @Before("logMethodPointCut()")
    public void logBefore() {
        System.out.println("Logging method before method calling() >>>>>>");
    }

    @After("logMethodPointCut()")
    public void logAfter() {
        System.out.println("Logging method after method calling() >>>>>>>");
    }
}
