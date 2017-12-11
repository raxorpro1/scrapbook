package com.mordorst.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.mordorst.springboot.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.mordorst.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Scrapbook {

	public static void main(String[] args) {
		SpringApplication.run(Scrapbook.class, args);
	}
}
