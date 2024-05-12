package com.eojin.fullstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullstackApplication {

	private static final Logger logger =
			LoggerFactory.getLogger(FullstackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
		logger.info("[ 풀스택 프로젝트 연습 : SpringBoot, React, MySQL ]");
	}

}
