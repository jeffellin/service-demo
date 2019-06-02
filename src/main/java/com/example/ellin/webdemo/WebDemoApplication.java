package com.example.ellin.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebDemoApplication {

	/**
	 * Hello world spring app.
	 * @param args
	 */
	public static void main(String[] args) {



		SpringApplication springApplication = new SpringApplication(WebDemoApplication.class);
		springApplication.addListeners(new PropertiesLogger());
		springApplication.run(args);


	}

}
