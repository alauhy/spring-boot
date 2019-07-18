package com.oocl.fullstack.springboot.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procuratorate")
public class Procuratorate {
    @UniqueElements
    private String name;
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "procuratorate_id")
    private List<File> files;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "procuratorate_id")
    private List<Procurator> procurators;

    public List<Procurator> getProcurators() {
        return procurators;
    }

    public void setProcurators(List<Procurator> procurators) {
        this.procurators = procurators;
    }

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
