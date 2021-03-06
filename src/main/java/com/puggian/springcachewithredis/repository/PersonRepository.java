package com.puggian.springcachewithredis.repository;

import com.puggian.springcachewithredis.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
