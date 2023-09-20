package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Category;
import com.bassure.ims.productservice.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    
    
    public String addCategory(CategoryRequest category);

    public List<Category> getAllCategory();

    public Category getCategoryById(String parentId);

    public String editCategory(Category category);
}
