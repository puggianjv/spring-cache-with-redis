package com.puggian.springcachewithredis.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String name;

}
