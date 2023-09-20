package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Supplier;
import com.bassure.ims.productservice.repository.SupplierRepository;
import com.bassure.ims.productservice.response.DeleteResponse;
import com.bassure.ims.productservice.response.UpdateResponse;
import com.bassure.ims.productservice.service.SupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier addSupplier(Supplier supplier) {

        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(String id) {

        return supplierRepository.findById(id).get();

    }

    @Override
    public List<Supplier> getAllSupplier() {

        return supplierRepository.findAll();

    }

    @Override
    public DeleteResponse deleteSupplierById(String id) {

        try {

            supplierRepository.deleteById(id);

            return new DeleteResponse(true, "Product deleted successfully id - " + id);

        } catch (Exception e) {

            return new DeleteResponse(false, "Error deleting product");
        }

    }

    @Override
    public UpdateResponse updateSupplier(Supplier supplier) {
        Supplier supplierResult = null;
        try {
            supplierResult = supplierRepository.save(supplier);
            return UpdateResponse.builder()
                    .isSuccess(true)
                    .supplier(supplierResult)
                    .build();

        } catch (Exception e) {

            e.printStackTrace();
            return UpdateResponse.builder()
                    .isSuccess(false)
                    .supplier(supplierResult)
                    .build();
        }

    }

}
