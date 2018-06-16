package com.lwb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lwb.*.dao")
public class LwbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwbApplication.class, args);
	}
}
