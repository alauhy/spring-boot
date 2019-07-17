package com.oocl.fullstack.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procurator")
public class Procurator {
    private String name;
    @Id
    @GeneratedValue
    private int id;
    @OneToMany
    @JoinColumn(name = "file_id")
    private List<File> files;

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

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
