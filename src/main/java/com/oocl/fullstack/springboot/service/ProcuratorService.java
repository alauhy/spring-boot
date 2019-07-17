package com.oocl.fullstack.springboot.service;

import com.oocl.fullstack.springboot.model.Procurator;
import com.oocl.fullstack.springboot.repository.ProcuratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcuratorService implements ProcuratorImpl {
    @Autowired
    private ProcuratorRepository procuratorRepository;

    @Override
    public Procurator findById(int id) {
        return procuratorRepository.findById(id).get();
    }
}
