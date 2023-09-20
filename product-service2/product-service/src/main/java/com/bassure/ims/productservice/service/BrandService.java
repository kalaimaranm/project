
package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Brand;
import java.util.List;


public interface BrandService {
      
    List<Brand> getAllBrand();
    Brand addBrand(Brand brand);
}
