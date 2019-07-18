package com.oocl.fullstack.springboot.repository;

import com.oocl.fullstack.springboot.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File,Integer> {
    List<File> findAllByOrderByTimeDesc();
    List<File> findByName(String name);
}

