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
import java.util.Objects;

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
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("error", "No Data Found")).build())
                    .build();
        }
    }

    @GetMapping("/getcategory/{parentId}")
    public ResponseEntity getCategory(@PathVariable String parentId) {
        Category category = categoryService.getCategoryById(parentId);
        if (Objects.nonNull(category)) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(category).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("error", "No Data Found")).build())
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
    @PostMapping("/newcategory")
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

    @PutMapping("/updateproduct")    // update category?
    public ResponseEntity updateCategory(@RequestBody Category category) {
        String updatedCategory = categoryService.editCategory(category);
        if (updatedCategory != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(updatedCategory).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("", "")).build()) // why not null?
                    .build();
        }
    }
}
