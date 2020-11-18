package com.psoft.aplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan( basePackages = {"psoft.controller"} )
@EnableWebMvc
@EnableAutoConfiguration
public class PsoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsoftApplication.class, args);
		System.out.println("\nCONFIGURAÇÕES FUNCIONANDO!!!");	
	}

}
