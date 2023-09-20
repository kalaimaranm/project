
package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Brand;
import com.bassure.ims.productservice.service.BrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("brand")
public class BrandController {
   
    
      @Autowired
    BrandService brandService;
      
      @PostMapping
      public Brand addBrand( @RequestBody Brand brand){
       
          //return brand;
          return brandService.addBrand(brand);
      }
      
      
      @GetMapping
      public List<Brand> getAllBrand(){
          
          
          return brandService.getAllBrand();
      }
    
}
