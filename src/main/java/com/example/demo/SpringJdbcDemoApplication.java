package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.springjdbc.entity.Person;

@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
  
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  PersonJdbcDAO dao;
  
  //jdbc:h2:mem:testdb
  //org.h2.Driver
  //user: sa
  
  

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    
	  
    logger.info("All users -> {}", dao.findAll());
    
    logger.info("User id 10002 -> {} ", dao.findById(10002));
    
    logger.info("Deleting 10002 -> No of Rows Deleted - {}", dao.deleteById(10001));
    
    logger.info("Inserting 10005 -> {}", dao.insert(new Person(10005, "New Mars", "New Jupiter", new Date())));
    
     logger.info("Update 10003 -> {} ", dao.update(new Person(10003, "Eduardo Update", "Jupiter Update", new Date())));
    
  }
	
	
}
