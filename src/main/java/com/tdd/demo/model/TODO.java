package com.tdd.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vtsutsman on 7/12/17.
 */
@Entity
public class TODO {

    @Id
    private Long id;
    private String name;

    public TODO() {
    }

    public TODO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
