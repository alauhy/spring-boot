package com.oocl.fullstack.springboot.repository;

import com.oocl.fullstack.springboot.model.Procurator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcuratorRepository extends JpaRepository<Procurator,Integer> {
}
