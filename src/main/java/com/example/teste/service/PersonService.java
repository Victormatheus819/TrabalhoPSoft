package com.example.teste.service;

import com.example.teste.dao.PersonDao;
import com.example.teste.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDao personDao;
    @Autowired 
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
         this.personDao = personDao;
     }

    public int addPerson (Person person){
         return personDao.insertPerson(person);

    }
    
}
