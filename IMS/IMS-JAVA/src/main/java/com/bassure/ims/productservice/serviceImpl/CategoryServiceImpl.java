package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Asset;
import com.bassure.ims.productservice.collection.Category;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.HttpStatusMessage;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.CategoryRepository;
import com.bassure.ims.productservice.repository.ModelRepository;
import com.bassure.ims.productservice.request.CategoryRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.CategoryService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HttpStatusCode httpStatusCode;
    @Autowired
    private HttpStatusMessage httpStatusMessage;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryRequest, category);
        category.setCategoryId(sequenceGeneratorService.generateSequence(UtilsConfig.getCATEGORY_SEQUENCE_NAME()));
        category.setCreatedAt(LocalDateTime.now());
        category.setStatus("ACTIVE");
        Category saved = categoryRepository.save(category);
        if (!Objects.isNull(saved.getCategoryName())) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), httpStatusMessage.getSuccess());
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getError(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
        }
    }

    @Override
    public ResponseEntity getAllCategory() {
//        List<Category> parentCategory = new ArrayList<>();
//        List<Category> subCategory = new ArrayList<>();
//        List<Category> allCategory = categoryRepository.findAll();
//        for (Category ca : allCategory) {
//            if (ca.getParentCategoryId() == null) {
//                parentCategory.add(ca);
//            } else {
//                subCategory.add(ca);
//            }
//        }
//        System.out.println("parentCategory : " + parentCategory);
//        System.out.println("parentCategory : " + subCategory);
        List<Category> categoryList = categoryRepository.findAll();
        if (!categoryList.isEmpty()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), categoryList);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getNoDataFound()));
        }
    }

    @Override
    public ResponseEntity getCategoryById(String parentId) {
        Optional<List<Category>> parentCategoryId = categoryRepository.findByParentCategoryId(parentId);
        if (parentCategoryId.isPresent()) {
            List<Category> getCategory;
            List<Category> all = categoryRepository.findAll();
            if (parentId == null) {
                getCategory = all.stream()
                        .filter(data -> data.getParentCategoryId() == null)
                        .collect(Collectors.toList());
            } else {
                getCategory = all.stream()
                        .filter(data -> data.getParentCategoryId() != null)
                        .collect(Collectors.toList());
            }
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), getCategory);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getNoDataFound()));
        }
    }

    @Override
    public ResponseEntity editCategory(String categoryId, CategoryRequest categoryRequest) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category category = new Category();
            BeanUtils.copyProperties(categoryRequest, category);
            category.setCategoryId(optionalCategory.get().getCategoryId());
            category.setCreatedAt(optionalCategory.get().getCreatedAt());
            category.setStatus(optionalCategory.get().getStatus());
            categoryRepository.save(category);
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), httpStatusMessage.getEditMessage());
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getFailed(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
        }
    }

    @Override
    public ResponseEntity deleteCategory(String categoryId) {
        System.out.println(modelRepository.findByCategoryId(categoryId).isEmpty());
        if (getCategoryById(categoryId).getCode() == httpStatusCode.getSuccess()
                && modelRepository.findByCategoryId(categoryId).isEmpty()) {
            Query query = new Query(Criteria.where("id").is(categoryId));
            Update update = new Update().set("status", "INACTIVE");
            UpdateResult result = mongoTemplate.updateFirst(query, update, Asset.class);
            if (result.getModifiedCount() > 0) {
                return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), httpStatusMessage.getDeleteMessage());
            }
        }
        return UtilsResponse.responsesEntity(httpStatusCode.getFailed(), Map.of(httpStatusMessage.getErrorKey(), httpStatusMessage.getFailed()));
    }
}
