package com.example.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.webapp.repository.ApiAuthMapper;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class WebappApplicationTest {
/*
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args).getBean(WebappApplication.class).exe();
	}
	
	/**DI*/
	private final ApiAuthMapper mapper;
	
	public void exe() {
		System.out.println("取得テスト");
		System.out.println(mapper.findByApiKeyAndCliendIp("10.100.100","abcdefghij"));
	}
	
	
	
}
