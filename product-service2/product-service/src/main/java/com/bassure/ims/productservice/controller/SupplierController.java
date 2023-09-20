package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Supplier;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;
import com.bassure.ims.productservice.response.UpdateResponse;
import com.bassure.ims.productservice.serviceImplementation.SupplierServiceImpl;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @GetMapping()
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
                .body(ResponseBody.builder().value(supplier).error("no supplier available").build())
                .build();

    }

    @GetMapping("/{id}")
    public ResponseEntity getSupplierById(@PathVariable String id) {

        Supplier supplier = supplierServiceImpl.getSupplierById(id);

        if (Objects.nonNull(supplier)) {

            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(supplier).error(null).build())
                    .build();
        }

        return ResponseEntity.builder()
                .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                .body(ResponseBody.builder().error("supplier not found id - " + id).value(supplier).build())
                .build();
    }

//    @DeleteMapping("/{id}")
//    public String deleteSupplierById(@PathVariable String id) {
//
//        return null;
//    }
    
    @PostMapping()
    public ResponseEntity addSupplier(@RequestBody Supplier supplier) {

        Supplier supplierResult = supplierServiceImpl.addSupplier(supplier);

        if (supplierResult != null) {

            return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(supplierResult).error(null).build())
                    .build();
        }

        return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                .body(ResponseBody.builder().value(supplierResult).error("supplier addition failed").build())
                .build();
    }

    @PutMapping()
    public ResponseEntity updateSupplier(@RequestBody Supplier supplier) {

        UpdateResponse supplierResult = supplierServiceImpl.updateSupplier(supplier);

        if (supplierResult.isSuccess()) {

            return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().error(null).value(supplierResult).build())
                    .build();

        }

        return ResponseEntity.builder().header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                .body(ResponseBody.builder().error("suplier updation failed").value(supplierResult).build())
                .build();
    }

}
