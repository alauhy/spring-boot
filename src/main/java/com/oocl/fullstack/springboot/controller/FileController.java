package com.oocl.fullstack.springboot.controller;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/files")
    public ResponseEntity addFile(@RequestBody File file) {
        if (file.getName() != null && file.getTime() != 0) {
            fileService.saved(file);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping("/files")
    public List<File> allFiles() {
        return fileService.allFiles();
    }

    @GetMapping("/files/{id}")
    public File findById(@PathVariable int id){
        return fileService.findById(id);
    }

    @GetMapping("/files/{name}")
    public List<File> findByName(@PathVariable String name){
        return fileService.findByName(name);
    }

}
