package com.sharing.App;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * sptingbott启动类
 */
@MapperScan("com.sharing.dao")
@SpringBootApplication(scanBasePackages = {"com.sharing.controller","com.sharing.service"})
public class SharingPlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(SharingPlatformApplication.class, args);
	}
}

