package com.oocl.fullstack.springboot.service;

import com.oocl.fullstack.springboot.model.FileRecord;

public interface FileRecordImpl {
    FileRecord save(FileRecord fileRecord);

    FileRecord findById(int id);
}
