package com.loveincode;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@EnableRabbit
@ComponentScan(basePackages = "com.loveincode.*")
@MapperScan(basePackages = "com.loveincode.mapper")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		System.out.println("Application start...");
		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("Application started...");
	}
}
