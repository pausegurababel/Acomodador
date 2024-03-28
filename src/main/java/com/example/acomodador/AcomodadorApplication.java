package com.example.acomodador;

import com.example.acomodador.configuration.AppConfig;
import com.example.acomodador.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AcomodadorApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Controller constructorApplication = context.getBean(Controller.class);

		constructorApplication.run();
	}

}
