package com.borasahin.application.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.arslan","com.borasahin"})
public class ParserApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ParserApplication.class, args);
	}

}
