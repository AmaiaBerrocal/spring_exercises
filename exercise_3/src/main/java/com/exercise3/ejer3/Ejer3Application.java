package com.exercise3.ejer3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejer3Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejer3Application.class, args);

		CarRepository repo = context.getBean(CarRepository.class);

		Car car = new Car(null, 2016, "lalala", "Lololo");
		repo.save(car);
		System.out.println(repo.findAll());
	}

}
