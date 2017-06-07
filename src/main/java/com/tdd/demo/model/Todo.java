package com.tdd.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    @Column( length = 64 )
    private String todo;
}
