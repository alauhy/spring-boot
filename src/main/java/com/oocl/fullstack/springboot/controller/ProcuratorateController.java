package com.oocl.fullstack.springboot.controller;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.Procuratorate;
import com.oocl.fullstack.springboot.service.ProcuratorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProcuratorateController {
    @Autowired
    private ProcuratorateService procuratorateService;

    @GetMapping("/procurators/{id}")
    public Procuratorate findById(@PathVariable int id){
        return procuratorateService.findById(id);
    }

    @PostMapping("/procurators/{id}/files")
    public Procuratorate addFile2Procurator(@PathVariable int id , @RequestBody File file){
        return procuratorateService.addFile2Procurator(id,file);
    }

}

