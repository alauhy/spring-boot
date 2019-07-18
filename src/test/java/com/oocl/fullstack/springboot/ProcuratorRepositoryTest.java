package com.oocl.fullstack.springboot;

import com.oocl.fullstack.springboot.model.Procurator;
import com.oocl.fullstack.springboot.model.Procuratorate;
import com.oocl.fullstack.springboot.repository.ProcuratorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProcuratorRepositoryTest {
    @Autowired
    private ProcuratorRepository procuratorRepository;

    @Test
    void should_save_and_fetch_procuratorate() {
        Procurator procurator = new Procurator();
        procurator.setName("lxy");

        procuratorRepository.save(procurator);
        Procurator procurator1 = procuratorRepository.findById(procurator.getId()).get();

        assertThat(procurator1.getName()).isEqualTo("lxy");
    }

    @Test
    void should_delete_procuratorate_by_id() {
        Procurator procurator = new Procurator();
        procurator.setName("lxy");
        Procurator procurator2 = new Procurator();
        procurator2.setName("lqq");

        procuratorRepository.save(procurator);
        procuratorRepository.save(procurator2);
        procuratorRepository.deleteById(procurator.getId());
        List<Procurator> procurators = procuratorRepository.findAll();

        assertThat(procurators.get(0).getName()).isEqualTo("lqq");
        assertThat(procurators.size()).isEqualTo(1);
    }
}
