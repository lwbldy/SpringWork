package com.lwb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // 开启缓存，需要显示的指定
public class SpringBootShiroEhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShiroEhcacheApplication.class, args);
	}

}
