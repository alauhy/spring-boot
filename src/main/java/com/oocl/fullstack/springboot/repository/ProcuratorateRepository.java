package com.oocl.fullstack.springboot.repository;

import com.oocl.fullstack.springboot.model.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ProcuratorateRepository extends JpaRepository<Procuratorate,Integer> {
}
