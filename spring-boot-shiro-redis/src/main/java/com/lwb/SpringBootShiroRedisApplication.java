package com.lwb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启缓存注解
@EnableCaching
public class SpringBootShiroRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShiroRedisApplication.class, args);
	}
}
