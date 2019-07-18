package com.oocl.fullstack.springboot;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.FileRecord;
import com.oocl.fullstack.springboot.repository.FileRecordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class FileRecordTest {
    @Autowired
    private FileRecordRepository fileRecordRepository;

    @Test
    void should_save_and_fetch_by_record_id() {
        FileRecord fileRecord = new FileRecord();
        fileRecord.setObjectiveDetail("111");
        fileRecord.setSubjectiveDetail("222");

        fileRecordRepository.save(fileRecord);
        FileRecord fileRecords = fileRecordRepository.findById(fileRecord.getId()).get();

        assertThat(fileRecords.getObjectiveDetail()).isEqualTo("111");
        assertThat(fileRecords.getSubjectiveDetail()).isEqualTo("222");
    }

    @Test
    void should_delete_fileRecord_by_id() {
        FileRecord fileRecord = new FileRecord();
        fileRecord.setObjectiveDetail("111");
        fileRecord.setSubjectiveDetail("222");
        FileRecord fileRecord2 = new FileRecord();
        fileRecord2.setObjectiveDetail("333");
        fileRecord2.setSubjectiveDetail("444");

        fileRecordRepository.save(fileRecord);
        fileRecordRepository.save(fileRecord2);
        fileRecordRepository.deleteById(fileRecord.getId());
        List<FileRecord> fileRecords = fileRecordRepository.findAll();

        assertThat(fileRecords.size()).isEqualTo(1);
        assertThat(fileRecords.get(0).getObjectiveDetail()).isEqualTo("333");
        assertThat(fileRecords.get(0).getSubjectiveDetail()).isEqualTo("444");
    }


}
