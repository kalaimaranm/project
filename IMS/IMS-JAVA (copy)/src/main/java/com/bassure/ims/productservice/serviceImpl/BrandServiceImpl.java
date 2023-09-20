
package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Brand;
import com.bassure.ims.productservice.repository.BrandRepository;
import com.bassure.ims.productservice.service.BrandService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    BrandRepository brandRepo;
    
    @Override
    public Brand addBrand(Brand brand){
        if(brand==null){
            throw new IllegalArgumentException("Some field in brand must not be empty.");
        }
        brand.setCreatedAt(LocalDateTime.now());
        return brandRepo.save(brand);
    }
    
    @Override
    public List<Brand> getAllBrand(){
        return brandRepo.findAll();
    }
    
}
