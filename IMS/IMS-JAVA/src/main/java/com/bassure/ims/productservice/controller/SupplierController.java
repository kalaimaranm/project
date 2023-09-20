package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.request.SupplierRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getallsupplier")
    public ResponseEntity getAllSuppliers() {
        return supplierService.getAllSupplier();
    }

    @GetMapping("/getsupplier/{id}")
    public ResponseEntity getSupplierById(@PathVariable String id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping("/addsupplier")
    public ResponseEntity addSupplier(@RequestBody SupplierRequest supplierRequest) {
        return supplierService.addSupplier(supplierRequest);
    }


    @PutMapping("/updatesupplier/{supplierId}")
    public ResponseEntity updateSupplier(@PathVariable String supplierId, @RequestBody SupplierRequest supplierRequest) {
        return supplierService.updateSupplier(supplierId, supplierRequest);
    }

//    @DeleteMapping("/{id}")
//    public String deleteSupplierById(@PathVariable String id) {
//
//        return null;
//    }
}
