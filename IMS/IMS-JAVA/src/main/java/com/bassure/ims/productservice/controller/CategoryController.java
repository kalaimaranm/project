package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.request.CategoryRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private HttpStatusCode status;

    @GetMapping("/getcategory")
    public ResponseEntity getCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/getcategory/{parentId}")
    public ResponseEntity getCategory(@PathVariable @NotNull String parentId) {
        return categoryService.getCategoryById(parentId);
    }

    @PostMapping("/newcategory")
    public ResponseEntity newCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return categoryService.addCategory(categoryRequest);
    }

    @PutMapping("/updatecategory/{categoryId}")
    public ResponseEntity updateCategory(@PathVariable @NotNull String categoryId, @Valid @RequestBody CategoryRequest categoryRequest) {
        return categoryService.editCategory(categoryId, categoryRequest);
    }

    @PutMapping("/deletecategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id) {
        return categoryService.deleteCategory(id);
    }
}
