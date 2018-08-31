package com.example.demo;

import com.example.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {
  
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    
    logger.info("All users -> {}", dao.findAll());
    
    logger.info("User id 10002 -> {} ", dao.findById(10002));
    
    logger.info("Deleting 10002 -> No of Rows Deleted - {}", dao.deleteById(10001));
    
    logger.info("Inserting 10005 -> {}", dao.insert(new Person(10005, "New Mars", "Mars", new Date())));
    
    logger.info("Update 10003 -> {} ", dao.update(new Person(10003, "Eduardo Update", "Jupiter Update", new Date())));
    
  }
	
	
}
