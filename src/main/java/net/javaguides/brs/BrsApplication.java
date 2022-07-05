package net.javaguides.brs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.javaguides.brs.service.BookService;

@SpringBootApplication
public class BrsApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BrsApplication.class, args);
	}
	

}
