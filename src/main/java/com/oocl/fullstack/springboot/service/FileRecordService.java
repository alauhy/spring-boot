package com.oocl.fullstack.springboot.service;

import com.oocl.fullstack.springboot.model.FileRecord;
import com.oocl.fullstack.springboot.repository.FileRecordRepository;
import com.oocl.fullstack.springboot.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileRecordService implements FileRecordImpl {
    @Autowired
    private FileRecordRepository fileRecordRepository;

    @Override
    public FileRecord save(FileRecord fileRecord) {
        return fileRecordRepository.save(fileRecord);
    }

    @Override
    public FileRecord findById(int id) {
        return fileRecordRepository.findById(id).get();
    }

}
