package com.oocl.fullstack.springboot.controller;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.FileRecord;
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
    public File addFile(@RequestBody File file) {

            return fileService.saved(file);


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

    @DeleteMapping("/files/{id}")
    public ResponseEntity deleteFile(@PathVariable int id ){
        fileService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
