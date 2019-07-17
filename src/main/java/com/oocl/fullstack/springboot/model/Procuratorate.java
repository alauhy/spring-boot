package com.oocl.fullstack.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procuratorate")
public class Procuratorate {
    private String name;
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(mappedBy = "procuratorate")
    private List<File> files;

    @OneToMany(mappedBy = "procuratorate")
    private List<Procurator> procurators;

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
