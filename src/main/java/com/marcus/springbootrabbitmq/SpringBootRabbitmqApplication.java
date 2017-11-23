package com.marcus.springbootrabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootRabbitmqApplication {

	@Autowired
	private ConfigurableApplicationContext ctx;

	@Profile("usage_message")
	@Bean
	public CommandLineRunner usage() {
		return arg0 -> {
			System.out.println("");
			System.out.println("This app uses Spring Profiles to control its behavior.");
            System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
			System.out.println("Or go to tut1-6 and see README.md files for other profiles");
			System.out.println("");

			// close web application
			ctx.close();
		};
	}

	@Profile("!usage_message")
	@Bean
	public CommandLineRunner tutorial() {
		return new RabbitAmqpTutorialsRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitmqApplication.class, args);
	}
}
