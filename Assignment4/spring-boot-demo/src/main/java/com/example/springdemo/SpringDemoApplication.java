package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.TimeZone;

@Controller
@SpringBootApplication
public class SpringDemoApplication {


	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(SpringDemoApplication.class, args);

	}
}


//////============= RUN AS TOMCAT - WAR ============
//@SpringBootApplication
//public class DBApiApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(DBApiApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(DBApiApplication.class, args);
//	}
//}
