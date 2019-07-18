package com.oocl.fullstack.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "file_record")
public class FileRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String objectiveDetail;
    @NotNull
    private String subjectiveDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjectiveDetail() {
        return objectiveDetail;
    }

    public void setObjectiveDetail(String objectiveDetail) {
        this.objectiveDetail = objectiveDetail;
    }

    public String getSubjectiveDetail() {
        return subjectiveDetail;
    }

    public void setSubjectiveDetail(String subjectiveDetail) {
        this.subjectiveDetail = subjectiveDetail;
    }
}
