package com.oocl.fullstack.springboot.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "procurator")
public class Procurator {
    @NotNull
    @UniqueElements
    private String name;

    @Id
    @GeneratedValue
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
