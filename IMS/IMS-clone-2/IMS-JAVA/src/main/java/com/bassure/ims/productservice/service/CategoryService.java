package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Category;

import java.util.List;

public interface CategoryService {
    public String addCategory(Category category);

    public List<Category> getAllCategory();

    public List<Category> getCategoryById(String parentId);

    public String editCategory(String id, Category category);
}
