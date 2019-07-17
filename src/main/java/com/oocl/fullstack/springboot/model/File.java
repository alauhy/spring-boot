package com.oocl.fullstack.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "file")
public class File {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;
    @NotNull
    private long time;

    public FileRecord getFileRecord() {
        return fileRecord;
    }

    public void setFileRecord(FileRecord fileRecord) {
        this.fileRecord = fileRecord;
    }

    @OneToOne
    @JoinColumn(name = "filerecord_id")
    private FileRecord fileRecord;

}
