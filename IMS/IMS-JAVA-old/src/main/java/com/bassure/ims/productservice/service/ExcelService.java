package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.AssertExcel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    public List<AssertExcel> uploadExcelFile(MultipartFile file);
}
