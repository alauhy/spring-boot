package com.oocl.fullstack.springboot.service;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.FileRecord;
import com.oocl.fullstack.springboot.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService implements FileImpl {
    @Autowired
    FileRepository fileRepository;

    @Override
    public List<File> allFiles() {
        return fileRepository.findAll()
                .stream().sorted(Comparator.comparing(File::getTime).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public File findById(int id) {
        return fileRepository.findById(id).get();
    }

    @Override
    public List<File> findByName(String name) {
        return fileRepository.findAll().stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public File addFileRecordToFile(int id, FileRecord fileRecord) {
        File file = findById(id);
        file.setFileRecord(fileRecord);
        return fileRepository.save(file);

    }

    @Override
    public File saved(File file) {
        return fileRepository.save(file);
    }

    @Override
    public void deleteById(int id) {
        fileRepository.deleteById(id);
    }


}
