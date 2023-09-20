
package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.request.SupplierRequest;
import com.bassure.ims.productservice.response.ResponseEntity;


public interface SupplierService {
     
     ResponseEntity addSupplier(SupplierRequest supplierRequest);

     ResponseEntity getSupplierById(String supplierId);

     ResponseEntity getAllSupplier();

     ResponseEntity deleteSupplierById(String supplierId);

     ResponseEntity updateSupplier(String supplierId, SupplierRequest supplierRequest);
    
}
