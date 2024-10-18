package com.academy.sportApp.aspect;

import com.academy.sportApp.model.entity.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WorkAspect {
    @Pointcut("execution(* com.academy.sportApp.service.TaskService.performPermissionSetup(currentUsername, user) )")
    public void performTaskPointCut(String currentUsername, User user){
        System.out.println("hello from aspect");
    }

    @Before("performTaskPointCut(currentUsername, user)")
    public void beforeWork(String currentUsername, User user) {
        if(currentUsername.equals(user.getUsername())){

        }
        System.out.println("task before work");
    }

/*
    @After("performTaskPointCut()")
    public void afterWork() {
        System.out.println("After work");
    }
    */

}