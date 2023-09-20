
package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Brand;
import com.bassure.ims.productservice.collection.ResponseEntity;
import com.bassure.ims.productservice.serviceImpl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("brand")
public class BrandController {
    
      @Autowired
      BrandServiceImpl brandService;
      
      @PostMapping("/addbrand")
      public Brand addBrand( @RequestBody Brand brand){
       
      
          return brandService.addBrand(brand);
      }
      
      
      @GetMapping("/getallbrand")
      public List<Brand> getAllBrand(){
          
          
          return brandService.getAllBrand();
      }
      
      @PutMapping("/updatebrand")
      public  ResponseEntity updateBrand(){
          return ResponseEntity.builder().build();
      }
    
}
