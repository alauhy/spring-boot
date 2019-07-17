package com.oocl.fullstack.springboot.controller;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.FileRecord;
import com.oocl.fullstack.springboot.service.FileRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileRecordController {
    @Autowired
    private FileRecordService fileRecordService;

    @PostMapping("/filesrecords")
    public FileRecord addFileRecord(@RequestBody FileRecord fileRecord){
        return fileRecordService.save(fileRecord);
    }

    @GetMapping("/filesrecords/{id}")
    public FileRecord findById(@PathVariable int id ){
        return fileRecordService.findById(id);
    }

}
