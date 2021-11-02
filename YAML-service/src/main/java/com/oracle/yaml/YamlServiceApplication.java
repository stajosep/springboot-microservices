package com.oracle.yaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oracle.yaml.config.ServerProperties;

@SpringBootApplication
public class YamlServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(YamlServiceApplication.class, args);
	}

	@Autowired
	private ServerProperties serverProperties;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(serverProperties);
	}

}
