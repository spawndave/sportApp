package com.academy.sportApp;

import com.academy.sportApp.model.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SportAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportAppApplication.class, args);
		var context = new ClassPathXmlApplicationContext("di_config.xml");
		User u = context.getBean(User.class);
		System.out.println(u);
	}

}
