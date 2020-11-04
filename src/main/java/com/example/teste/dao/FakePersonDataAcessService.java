package com.example.teste.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.example.teste.model.Person;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakePersonDataAcessService implements PersonDao {
    private static List <Person> DB= new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add (new Person(id, person.getName()));
        return 1;
    }
    
}
