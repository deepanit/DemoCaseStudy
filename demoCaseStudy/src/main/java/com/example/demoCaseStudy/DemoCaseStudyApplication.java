package com.example.demoCaseStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication (scanBasePackages = {"com.example.demoCaseStudy"})
public class DemoCaseStudyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoCaseStudyApplication.class);
	}

}
