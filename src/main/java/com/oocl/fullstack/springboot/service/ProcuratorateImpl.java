package com.oocl.fullstack.springboot.service;

import com.oocl.fullstack.springboot.model.File;
import com.oocl.fullstack.springboot.model.Procuratorate;

public interface ProcuratorateImpl {
    Procuratorate findById(int id);

    Procuratorate addFile2Procurator(int id, File file);

}
