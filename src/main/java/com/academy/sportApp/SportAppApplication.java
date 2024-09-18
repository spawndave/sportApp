package com.academy.sportApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportAppApplication.class, args);
		//var context = new AnnotationConfigApplicationContext(MainConfig.class);
		//TaskService service = context.getBean(TaskService.class);
		//service.performTask();
		//User u = context.getBean(User.class);
		System.out.println("SportApp starting..");
	}

}