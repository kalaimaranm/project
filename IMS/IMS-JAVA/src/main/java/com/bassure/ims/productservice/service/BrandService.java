
package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.request.BrandRequest;
import com.bassure.ims.productservice.response.ResponseEntity;


public interface BrandService {

    ResponseEntity getAllBrand();

    ResponseEntity addBrand(BrandRequest brand);

    ResponseEntity updateBrand(String brandId, BrandRequest brandRequest);

    ResponseEntity getBrandById(String brandId);

    ResponseEntity deleteBrand(String brandId);
}
