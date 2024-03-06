package com.amigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HcmsBackend1Application {

	public static void main(String[] args) {
		try {
			SpringApplication.run(HcmsBackend1Application.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
