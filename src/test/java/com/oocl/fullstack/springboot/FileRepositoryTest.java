package com.oocl.fullstack.springboot;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.FileRecord;
import com.oocl.fullstack.springboot.repository.FileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.awt.*;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class FileRepositoryTest {
    @Autowired
    private FileRepository fileRepository;

    @Test
    void should_save_and_find() {
        File file = new File();
        file.setName("黑色大丽花");
        file.setTime(121231345);
        FileRecord fileRecord = new FileRecord();
        fileRecord.setObjectiveDetail("111");
        fileRecord.setSubjectiveDetail("222");
        file.setFileRecord(fileRecord);

        fileRepository.save(file);
        File fetchedFile = fileRepository.findById(file.getId()).get();

        assertThat(fetchedFile.getName()).isEqualTo("黑色大丽花");
        assertThat(fetchedFile.getTime()).isEqualTo(121231345);


    }

    @Test
    void should_order_by_time_desc() {
        File file = new File();
        file.setName("黑色大丽花");
        file.setTime(121231345);
        File file1 = new File();
        file1.setName("开膛手杰克");
        file1.setTime(121231344);

        fileRepository.save(file);
        fileRepository.save(file1);
        List<File> fetchedFiles = fileRepository.findAllByOrderByTimeDesc();

        assertThat((fetchedFiles).get(1).getName()).isEqualTo("开膛手杰克");
        assertThat((fetchedFiles).get(1).getTime()).isEqualTo(121231344);


    }
    @Test
    void should_find_all_by_name() {
        File file = new File();
        file.setName("黑色大丽花");
        file.setTime(121231345);
        File file2 = new File();
        file2.setName("黑色大丽花");
        file2.setTime(121231344);
        File file3 = new File();
        file3.setName("开膛手杰克");
        file3.setTime(121231343);

        fileRepository.save(file);
        fileRepository.save(file2);
        fileRepository.save(file3);
        List<File> fetchedFiles = fileRepository.findByName("黑色大丽花");

        assertThat((fetchedFiles).size()).isEqualTo(2);
        assertThat((fetchedFiles).get(1).getName()).isEqualTo("黑色大丽花");
        assertThat((fetchedFiles).get(1).getTime()).isEqualTo(121231344);


    }

    @Test
    void should_delete_by_id() {
        File file = new File();
        file.setName("黑色大丽花");
        file.setTime(121231345);
        File file2 = new File();
        file2.setName("连环杀手的肖像");
        file2.setTime(121231344);
        File file3 = new File();
        file3.setName("开膛手杰克");
        file3.setTime(121231343);

        fileRepository.save(file);
        fileRepository.save(file2);
        fileRepository.save(file3);
        fileRepository.deleteById(2);
        List<File> fetchedFiles = fileRepository.findAll();

        assertThat((fetchedFiles).size()).isEqualTo(2);
        assertThat((fetchedFiles).get(1).getName()).isEqualTo("开膛手杰克");
        assertThat((fetchedFiles).get(1).getTime()).isEqualTo(121231343);
        assertThat((fetchedFiles).get(1).getId()).isEqualTo(3);


    }
    @Test
    void should_save_filerecord() {
        File file = new File();
        file.setName("黑色大丽花");
        file.setTime(121231345);
        FileRecord fileRecord = new FileRecord();
        fileRecord.setSubjectiveDetail("111");
        fileRecord.setObjectiveDetail("222");
        file.setFileRecord(fileRecord);
        fileRepository.save(file);
        File file1 = fileRepository.findById(1).get();

        assertThat(file1.getFileRecord().getObjectiveDetail()).isEqualTo("222");
        assertThat(file1.getFileRecord().getSubjectiveDetail()).isEqualTo("111");


    }
}
