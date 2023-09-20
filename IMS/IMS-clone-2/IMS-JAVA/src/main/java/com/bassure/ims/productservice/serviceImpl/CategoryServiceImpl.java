package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Category;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.repository.CategoryRepository;
import com.bassure.ims.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public String addCategory(Category category) {
        category.setCategoryId(UUID.randomUUID() + "-" + sequenceGeneratorService.generateSequence(UtilsConfig.getCATEGORY_SEQUENCE_NAME()));
        category.setCreatedAt(LocalDateTime.now());
        if (category != null) {
            categoryRepository.save(category);
            return "category added success";
        } else {
            return null;
        }
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> parentCategory = new ArrayList<>();
        List<Category> subCategory = new ArrayList<>();
        List<Category> allCategory = categoryRepository.findAll();
//        List<Category> parentCategory = allCategory.stream().filter(data -> data.getParentCategoryId() == null).toList();
//        List<Category> subCategory = allCategory.stream().filter(data -> data.getParentCategoryId() != null).toList();
        for (Category ca : allCategory) {
            if (ca.getParentCategoryId() == null) {
                parentCategory.add(ca);
            } else {
                subCategory.add(ca);
            }
        }
        System.out.println("parentCategory : " + parentCategory);
        System.out.println("parentCategory : " + subCategory);
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getCategoryById(String parentId) {
        List<Category> getCategory;
        List<Category> all = categoryRepository.findAll();
        if (parentId == null) {
            getCategory = all.stream().filter(data -> data.getParentCategoryId() == null).collect(Collectors.toList());
        } else {
            getCategory = all.stream().filter(data -> data.getParentCategoryId() != null).collect(Collectors.toList());
        }
        return getCategory;
    }

    @Override
    public String editCategory(String id, Category category) {
        if (id != null && category != null) {
            category.setCategoryId(id);
            category.setUpdatedAt(LocalDateTime.now());
            categoryRepository.save(category);
            return "category updated success";
        } else {
            return null;
        }
    }
}
