package com.oocl.fullstack.springboot.service;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.FileRecord;

import java.util.List;

public interface FileImpl {
    List<File> allFiles();
    File findById(int id);
    List<File> findByName(String name);
    void deleteById(int id);
    File saved(File file);

    File addFileRecordToFile(int id, FileRecord fileRecord);

}
