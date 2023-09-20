package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.request.CategoryRequest;
import com.bassure.ims.productservice.response.ResponseEntity;

public interface CategoryService {
    
     ResponseEntity addCategory(CategoryRequest category);

     ResponseEntity getAllCategory();

     ResponseEntity getCategoryById(String parentId);

     ResponseEntity editCategory(String categoryId, CategoryRequest categoryRequest);

     ResponseEntity deleteCategory(String id);
}
