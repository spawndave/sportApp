package com.academy.sportApp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WorkAspect {
    @Pointcut("execution(* com.academy.sportApp.service.TaskService.performTask())")
    public void performTaskPointCut(){}

    @Before("performTaskPointCut()")
    public void beforeWork() {
        System.out.println("Before work");
    }

    @After("performTaskPointCut()")
    public void afterWork() {
        System.out.println("After work");
    }

}