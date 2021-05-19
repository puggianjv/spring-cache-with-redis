package com.puggian.springcachewithredis.service;

import com.puggian.springcachewithredis.model.Person;
import com.puggian.springcachewithredis.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(String name) {
        Person person = new Person();
        person.setName(name);
        return personRepository.save(person);
    }

    public Optional<Person> find(long id) {
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
