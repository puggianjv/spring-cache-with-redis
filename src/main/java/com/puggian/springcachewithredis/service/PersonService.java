package com.puggian.springcachewithredis.service;

import com.puggian.springcachewithredis.model.Person;
import com.puggian.springcachewithredis.repository.PersonRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @CacheEvict(cacheNames = "Person",  allEntries = true)
    public Person save(String name) {
        Person person = new Person();
        person.setName(name);
        return personRepository.save(person);
    }

    @Cacheable(cacheNames = "Person", key = "#id")
    public Optional<Person> find(long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return personRepository.findById(id);
    }

    @Cacheable(cacheNames = "Person", key = "#root.method.name")
    public List<Person> findAll() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return personRepository.findAll();
    }
}
