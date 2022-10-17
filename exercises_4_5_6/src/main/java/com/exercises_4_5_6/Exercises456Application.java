package com.exercises_4_5_6;

import com.exercises_4_5_6.infrastructure.LaptopRepository;
import com.exercises_4_5_6.model.Laptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Exercises456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Exercises456Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop l1 = new Laptop(null, "Dell", "lala201", 14, 2001);
		Laptop l2 = new Laptop(null, "Dñlkl", "lapppl01", 14, 2021);

		laptopRepository.save(l1);
		laptopRepository.save(l2);
	}
}
