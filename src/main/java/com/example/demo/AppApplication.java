package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
public class AppApplication {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(AppApplication.class, args);
		
		
//		spring.h2.console.enabled=true
//				spring.datasource.platform=
//				spring.datasource.url=jdbc:h2:~/test
	}
	
	
}
