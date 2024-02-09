package com.taru.tasks;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Tasks microservice REST API Documentation",
				description = "TaskManager Tasks microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Timur Turianytsia",
						email = "turianytsia.timur@gmail.com",
						url = "https://github.com/2taru"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "For more info you can go to given GitHub project page",
				url = "https://github.com/2taru/TaskManagementSystem"
		)
)
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

}
