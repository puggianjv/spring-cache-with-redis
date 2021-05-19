package com.puggian.springcachewithredis.controller;

import com.puggian.springcachewithredis.dto.CreatePersonDTO;
import com.puggian.springcachewithredis.model.Person;
import com.puggian.springcachewithredis.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> find(@PathVariable long id) {
        Optional<Person> personOptional = personService.find(id);
        return personOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody CreatePersonDTO dto) {
        Person person = personService.save(dto.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> list = personService.findAll();
        return ResponseEntity.ok(list);
    }

}
