package com.fullsecurity.fullsecurity.services;

import com.fullsecurity.fullsecurity.models.ExcelTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface ExcelService {
    void save(MultipartFile file);
    List<ExcelTest> findAll();

    boolean hasExcelFormat(MultipartFile file);

    List<ExcelTest> excelToStuList(InputStream is);

}
