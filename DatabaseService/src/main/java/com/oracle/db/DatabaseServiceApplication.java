package com.oracle.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseServiceApplication implements CommandLineRunner{

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseServiceApplication.class);
	
	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("DB operation started - check dB server for updates");
		repository.save(new Book("GoLang"));
		repository.save(new Book("Spark"));
		repository.save(new Book("Java"));
		repository.save(new Book("Javascript"));
		repository.save(new Book("Python"));
		repository.save(new Book("Kotlin"));
		repository.save(new Book("Groovy"));
		
		System.out.println("\n findAll () ");
		repository.findAll().forEach(x -> System.out.println(x));
		
		System.out.println("\n findById () ");
		repository.findById(3L).ifPresent(x -> System.out.println(x));
		
		System.out.println("\n findByName () ");
		repository.findByName("Spark").forEach(x -> System.out.println(x));
		
		System.out.println("\n Update -view in adminer app for result  () ");
		repository.findById(3L).ifPresent((x) ->
		{
			x.setName("Java Basic 16");
			repository.save(x);
		});
		
		System.out.println("\n Delete -view in adminer app for result  () ");
		repository.findById(4L).ifPresent((x) ->
		{
			repository.delete(x);
		});
		
		System.out.println("\n Delete By id-view in adminer app for result  () ");
		
	//	repository.deleteById(5L);
		
		repository.findById(5L).ifPresent((x) ->
		{
			repository.deleteById(x.getId());
		});
		
		
		System.out.println("\n Delete all By name -view in adminer app for result  () ");
//		repository.deleteByName("GoLang"); // i tried writing an interface method in BookRepository similar to findByName but that didnt work.
//		
		repository.deleteAll(repository.findByName("Spark")); // this finds all records with Name "Spark" and deletes all.
	}

}
