package com.claytonpereira.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinApplication.class, args);
	}

}
