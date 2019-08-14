package com.yonyon;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringbootRedisReceiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisReceiceApplication.class, args);
	}

}
