package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongocrudApplication.class, args);
	}






	/*@Bean
	public Jongo jongo() {



		DB db;
		try {
			db = new MongoClient("127.0.0.1", 27017).getDB("test");
		} catch (UnknownHostException e) {
			throw new MongoException("Connection error : ", e);
		}
		return new Jongo(db);
	}

	@Bean
	public MongoCollection users() {
		return jongo().getCollection("users");
	}*/
}
