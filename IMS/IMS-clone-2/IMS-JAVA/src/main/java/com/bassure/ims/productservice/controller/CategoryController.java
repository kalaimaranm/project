package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Category;
import com.bassure.ims.productservice.collection.ResponseBody;
import com.bassure.ims.productservice.collection.ResponseEntity;
import com.bassure.ims.productservice.collection.ResponseHeader;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getcategory")
    public ResponseEntity getCategory() {
        List<Category> allCategory = categoryService.getAllCategory();
        if (!allCategory.isEmpty()) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(allCategory).build())
                    .build();
        }else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("error","No Data Found")).build())
                    .build();
        }
    }

    @GetMapping("/getcategory/{parentId}")
    public ResponseEntity getCategory(@PathVariable String parentId) {
        List<Category> category = categoryService.getCategoryById(parentId);
        if (!category.isEmpty()) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(category).build())
                    .build();
        }else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("error","No Data Found")).build())
                    .build();
        }
    }

//    @GetMapping("/getparentcategory")
//    public ResponseEntity getParentCategory() {
//        return ResponseEntity.builder()
//                .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
//                .body(ResponseBody.builder().build())
//                .build();
//    }
//
//    @GetMapping("/getsubcategory")
//    public ResponseEntity getSubCategory() {
//        return ResponseEntity.builder()
//                .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
//                .body(ResponseBody.builder().build())
//                .build();
//    }

    @PostMapping("/addcategory")
    public ResponseEntity newCategory(@RequestBody Category category) {
        String addedCategory = categoryService.addCategory(category);
        if (addedCategory != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(addedCategory).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("", "")).build())
                    .build();
        }
    }

    @PutMapping("/updatecategory/{id}")
    public ResponseEntity updateCategory(@PathVariable String id, @RequestBody Category category) {
        String editedCategory = categoryService.editCategory(id, category);
        if (editedCategory != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(editedCategory).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("", "")).build())
                    .build();
        }
    }
}
