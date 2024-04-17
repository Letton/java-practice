package ru.mirea.practice_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practice10Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Practice10Application.class, args);
		if (args.length > 0) {
			String beanName = args[0];
			Musician musician = ctx.getBean(beanName, Musician.class);
			musician.doMusic();
		} else {
			System.out.println("Please specify a bean name as an argument.");
		}
	}

}
