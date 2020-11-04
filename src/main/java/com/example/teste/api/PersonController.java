package com.example.teste.api;

import com.example.teste.model.Person;
import com.example.teste.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PersonController {
    private final PersonService personService ;
   @Autowired
    public PersonController (PersonService personService){
        this.personService =personService;
    }
    @PostMapping
    public void addPerson (Person person){
        personService.addPerson(person);
    }
    
}
