package ru.gb_spring.homeworkspring_04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.gb_spring.homeworkspring_04.repositories.SqlRequest;

@SpringBootApplication
@EnableConfigurationProperties(SqlRequest.class)
@ConfigurationPropertiesScan("ru.gb_spring.homeworkspring_04")
public class HomeWorkSpring04Application {
	public static void main(String[] args) {
		SpringApplication.run(HomeWorkSpring04Application.class, args);
	}

}
