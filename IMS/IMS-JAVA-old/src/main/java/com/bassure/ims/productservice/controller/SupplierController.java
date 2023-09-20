package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;
import com.bassure.ims.productservice.collection.Supplier;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.response.UpdateResponse;
import com.bassure.ims.productservice.serviceImpl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @GetMapping("/getallsupplier")
    public ResponseEntity getAllSuppliers() {

        List<Supplier> supplier = supplierServiceImpl.getAllSupplier();

        if (Objects.nonNull(supplier)) {

            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(supplier).error(null).build())
                    .build();
        }

        return ResponseEntity.builder()
                .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                .body(ResponseBody.builder().error(Map.of("", "")).build())
                .build();

    }

    @GetMapping("/getsupplier/{id}")
    public ResponseEntity getSupplierById(@PathVariable String id) {

        Supplier supplier = supplierServiceImpl.getSupplierById(id);

        if (Objects.nonNull(supplier)) {

            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(supplier).build())
                    .build();
        }

        return ResponseEntity.builder()
                .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                .body(ResponseBody.builder().error(Map.of("", "supplier not found id - " + id)).build())
                .build();
    }

//    @DeleteMapping("/{id}")
//    public String deleteSupplierById(@PathVariable String id) {
//
//        return null;
//    }
    @PostMapping("/addsupplier")
    public String addSupplier(@RequestBody Supplier supplier) {

        LocalDateTime date = LocalDateTime.now();
        supplier.setCreatedAt(date);

        Supplier supplierResult = supplierServiceImpl.addSupplier(supplier);

        return supplierResult != null ? "" : "";

//        if (supplierResult != null) {
//            return "";
//            return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
//                    .body(ResponseBody.builder().value(supplierResult).error(null).build())
//                    .build();
//    }
//        return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
//                .body(ResponseBody.builder().value(supplierResult).error(Map.of("", "supplier addition failed")).build())
//                .build();
    }

    @PutMapping("/updatesupplier")
    public ResponseEntity updateSupplier(@RequestBody Supplier supplier) {
        LocalDateTime date = LocalDateTime.now();
        supplier.setUpdatedAt(date);

        UpdateResponse supplierResult = supplierServiceImpl.updateSupplier(supplier);

        if (supplierResult.isSuccess()) {
            
            return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().error(null).value(supplierResult).build())
                    .build();

        }

        return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                .body(ResponseBody.builder().error(Map.of("", "suplier updation failed")).value(supplierResult).build())
                .build();
    }

}
