package com.isicod.net.springCas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringCasApplication {

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException {
		SpringApplication.run(SpringCasApplication.class, args);
	}
}
