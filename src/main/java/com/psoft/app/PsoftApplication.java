
package com.psoft.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PsoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsoftApplication.class, args);
		System.out.println("\nCONFIGURAÇÕES FUNCIONANDO!!!");	
	}

}
