package com.inprocdb.InMemoryDataManager;

import com.inprocdb.InMemoryDataManager.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InMemoryDataManagerApplication implements ApplicationRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(InMemoryDataManagerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("**************In Memory Database Manager**************");
		System.out.println("Hsqldb successfully intialized in memory database!");
		System.out.println(
				String.format("Number of default records added in DB: %s", personService.findAllPersons().size()));
	}

}
