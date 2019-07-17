package com.oocl.fullstack.springboot.controller;

import com.oocl.fullstack.springboot.model.Procurator;
import com.oocl.fullstack.springboot.service.ProcuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcuratorController {
    @Autowired
    private ProcuratorService procuratorService;

    @GetMapping("/procurators/{id}")
    public Procurator findById(@PathVariable int id){
        return procuratorService.findById(id);
    }

}

