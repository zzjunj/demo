package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jt.pojo.User;

@SpringBootApplication
@MapperScan("com.jt.mapper")
public class SpringBootDemo2Application {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootDemo2Application.class, args);
	}

}
