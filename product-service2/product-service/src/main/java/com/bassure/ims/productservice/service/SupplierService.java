package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Supplier;
import com.bassure.ims.productservice.response.DeleteResponse;
import com.bassure.ims.productservice.response.UpdateResponse;
import java.util.List;

public interface SupplierService {

    public Supplier addSupplier(Supplier supplier);

    public Supplier getSupplierById(String id);

    public List<Supplier> getAllSupplier();

    public DeleteResponse deleteSupplierById(String id);

    public UpdateResponse updateSupplier(Supplier supplier);

}
