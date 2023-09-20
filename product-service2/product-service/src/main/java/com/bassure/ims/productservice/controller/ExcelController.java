package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;
import com.bassure.ims.productservice.serviceImplementation.ExcelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
public class ExcelController {

    @Autowired
    private ExcelServiceImpl excelService;

    @PostMapping("/upload")
    public ResponseEntity fileUpload(@RequestParam(value = "file") MultipartFile file) {
        String customers = excelService.uploadExcelFile(file);
        if (customers != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(customers).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error("something went worng").build())
                    .build();
        }
    }
}
