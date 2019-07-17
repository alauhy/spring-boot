package com.oocl.fullstack.springboot.controller;

import com.oocl.fullstack.springboot.model.FileRecord;
import com.oocl.fullstack.springboot.service.FileRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileRecordController {
    @Autowired
    private FileRecordService fileRecordService;

    @PostMapping("/filesrecords")
    public FileRecord addFileRecord(@RequestBody FileRecord fileRecord){
        return fileRecordService.save(fileRecord);
    }

}
