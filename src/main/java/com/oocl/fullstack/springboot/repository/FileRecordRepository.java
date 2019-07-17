package com.oocl.fullstack.springboot.repository;

import com.oocl.fullstack.springboot.model.FileRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface FileRecordRepository extends JpaRepository<FileRecord,Integer> {
}
