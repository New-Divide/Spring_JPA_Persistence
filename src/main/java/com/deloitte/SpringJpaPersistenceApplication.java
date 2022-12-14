package com.deloitte;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deloitte.model.Tutorial;
import com.deloitte.repository.TutorialRepository;

@SpringBootApplication
public class SpringJpaPersistenceApplication implements CommandLineRunner {
	
	@Autowired
	TutorialRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPersistenceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  repository.save(new Tutorial("Java Spring", "Tut#2 Description", false));
	      repository.save(new Tutorial("Hibernate", "Tut#3 Description", false));
	      repository.save(new Tutorial("Spring Boot", "Tut#4 Description", false));
	      repository.save(new Tutorial("Spring Data JPA", "Tut#5 Description", false));
	      repository.save(new Tutorial("JPA EntityManager", "Tut#6 Description", false));
	      repository.save(new Tutorial("Spring Security", "Tut#7 Description", false));
	      
	  	  List<Tutorial> tutorials = new ArrayList<>();
	  	  tutorials = repository.getAll();
	  	  display(tutorials);
	}
	
	public void display(List<Tutorial> tutorials) {
		
		System.out.println(tutorials.size());
		tutorials.forEach(System.out::println);
	}
	
}
