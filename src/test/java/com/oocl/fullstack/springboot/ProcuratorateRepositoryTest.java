package com.oocl.fullstack.springboot;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.Procurator;
import com.oocl.fullstack.springboot.model.Procuratorate;
import com.oocl.fullstack.springboot.repository.ProcuratorateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProcuratorateRepositoryTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    void should_save_and_fetch_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("珠海市检察院");

        procuratorateRepository.save(procuratorate);
        Procuratorate procuratorate1 = procuratorateRepository.findById(procuratorate.getId()).get();

        assertThat(procuratorate1.getName()).isEqualTo("珠海市检察院");
    }

    @Test
    void should_delete_procuratorate_by_id() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("珠海市检察院");
        Procuratorate procuratorate2 = new Procuratorate();
        procuratorate2.setName("广州市检察院");

        procuratorateRepository.save(procuratorate);
        procuratorateRepository.save(procuratorate2);
        procuratorateRepository.deleteById(procuratorate.getId());
        List<Procuratorate> procuratorates = procuratorateRepository.findAll();

        assertThat(procuratorates.get(0).getName()).isEqualTo("广州市检察院");
        assertThat(procuratorates.size()).isEqualTo(1);
    }
    @Test
    void should_save_files_2_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("珠海市检察院");
        File file = new File();
        file.setTime(12313123);
        file.setName("jack the ripper");
        List<File> files = new ArrayList<>();
        files.add(file);
        procuratorate.setFiles(files);

        procuratorateRepository.save(procuratorate);
        Procuratorate procuratorates = procuratorateRepository.findById(procuratorate.getId()).get();

        assertThat(procuratorates.getFiles().get(0).getName()).isEqualTo("jack the ripper");
        assertThat(procuratorates.getFiles().get(0).getTime()).isEqualTo(12313123);
    }
    @Test
    void should_save_procurator_2_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("珠海市检察院");
        Procurator procurator = new Procurator();
        procurator.setName("lxy");
        Procurator procurator2 = new Procurator();
        procurator2.setName("lqq");
        Procurator procurator3 = new Procurator();
        procurator3.setName("dtt");
        List<Procurator> procurators = new ArrayList<>();
        procurators.add(procurator);
        procurators.add(procurator2);
        procurators.add(procurator3);
        procuratorate.setProcurators(procurators);

        procuratorateRepository.save(procuratorate);
        Procuratorate procuratorates = procuratorateRepository.findById(procuratorate.getId()).get();

        assertThat(procuratorates.getProcurators().size()).isEqualTo(3);
        assertThat(procuratorates.getProcurators().get(0).getName()).isEqualTo("lxy");
        assertThat(procuratorates.getProcurators().get(1).getName()).isEqualTo("lqq");
        assertThat(procuratorates.getProcurators().get(2).getName()).isEqualTo("dtt");
    }
}
