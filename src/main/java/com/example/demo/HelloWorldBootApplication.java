package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorldBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldBootApplication.class, args);
	}

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello how are you?";
	}

}
