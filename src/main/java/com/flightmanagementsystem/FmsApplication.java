package com.flightmanagementsystem;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class FmsApplication {
	
	final static Logger logger = org.slf4j.LoggerFactory.getLogger(FmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FmsApplication.class, args);
		logger.info("FMS Application is Running...........");
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.flightmanagementsystem")).build();
	}
}
