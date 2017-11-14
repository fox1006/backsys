package com.kuaifu.backsys;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@EnableTransactionManagement
@EnableAutoConfiguration
public class BacksysApplication {

	public static void main(String[] args) {
		
		new SpringApplicationBuilder(BacksysApplication.class).run(args);
	}
}
