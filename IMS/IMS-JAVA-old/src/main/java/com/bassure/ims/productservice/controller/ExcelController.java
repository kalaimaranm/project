package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.AssertExcel;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;
import com.bassure.ims.productservice.serviceImpl.ExcelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ExcelController {

    @Autowired
    private ExcelServiceImpl excelService;

    @Autowired
    private HttpStatusCode status;

    @PostMapping("/upload")
    public ResponseEntity fileUpload(@RequestParam(value = "file") MultipartFile file) {
        List<AssertExcel> customers = excelService.uploadExcelFile(file);
        if (customers != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(status.getSuccess()).build())
                    .body(ResponseBody.builder().value(customers).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(status.getError()).build())
                    .body(ResponseBody.builder().error(Map.of("error", "oops something went wrong")).build())
                    .build();
        }
    }
}
