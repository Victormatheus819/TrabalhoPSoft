package com.example.teste;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperTest {
    public SuperTest() {
        this.chamada();
    }

    public void chamada() {
        System.out.println("boladão");

    }
}
