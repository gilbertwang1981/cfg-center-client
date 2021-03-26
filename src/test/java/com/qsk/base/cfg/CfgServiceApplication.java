package com.qsk.base.cfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qsk.base")
public class CfgServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CfgServiceApplication.class, args);
	}
}
