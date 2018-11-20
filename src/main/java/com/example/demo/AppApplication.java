package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Department;

@SpringBootApplication
public class AppApplication {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(AppApplication.class, args);
		
		
//		spring.h2.console.enabled=true
//				spring.datasource.platform=
//				spring.datasource.url=jdbc:h2:~/test
	}
	
	
}
