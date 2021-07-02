package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//	private static final 
	Logger LOG = LoggerFactory.getLogger(Hello.class);

	// URL - http://localhost:8082/hello

	@RequestMapping("/hello") // endpoint, API
	public String hello() {
		LOG.info("Hello world! INFO");
		return "Hello world!";
	}
}