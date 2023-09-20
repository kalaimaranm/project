package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.AssetExcel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    public List<AssetExcel> uploadExcelFile(MultipartFile file);
}
