
package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Brand;
import com.bassure.ims.productservice.repository.BrandRepository;
import com.bassure.ims.productservice.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepo;

    @Override
    public Brand addBrand(Brand brand) {
        if (brand != null) {
            return brandRepo.insert(brand);
        } else {
            throw new IllegalArgumentException("Some field in brand must not be empty.");
        }
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepo.findAll();
    }
}
