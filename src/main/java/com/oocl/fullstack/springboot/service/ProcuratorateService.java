package com.oocl.fullstack.springboot.service;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.Procuratorate;
import com.oocl.fullstack.springboot.repository.ProcuratorateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcuratorateService implements ProcuratorateImpl {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Override
    public Procuratorate addFile2Procurator(int id, File file) {
        Procuratorate procuratorate = findById(id);
        procuratorate.getFiles().add(file);
        return procuratorateRepository.save(procuratorate);
    }

    @Override
    public Procuratorate findById(int id) {
        return procuratorateRepository.findById(id).get();
    }
}
