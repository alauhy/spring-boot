package com.oocl.fullstack.springboot.repository;

import com.oocl.fullstack.springboot.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,Integer> {
}
