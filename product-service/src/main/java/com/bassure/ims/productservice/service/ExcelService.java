package com.bassure.ims.productservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {
    public String uploadExcelFile(MultipartFile file);
}
