package com.husni.Tangerine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.husni.Tangerine.model.Student;
import com.husni.Tangerine.repository.StudentRepository;

@SpringBootApplication
public class TangerineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TangerineApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository){
		return args -> {
			Student s = new Student(null, "Husni" , 25);

			repository.save(s);
		};
	}
}
