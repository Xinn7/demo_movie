package com.example.demo_movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class DemoMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMovieApplication.class, args);
	}

}
