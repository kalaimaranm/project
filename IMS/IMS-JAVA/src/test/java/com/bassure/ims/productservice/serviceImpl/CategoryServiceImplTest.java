package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Category;
import com.bassure.ims.productservice.collection.Model;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.HttpStatusMessage;
import com.bassure.ims.productservice.repository.CategoryRepository;
import com.bassure.ims.productservice.repository.ModelRepository;
import com.bassure.ims.productservice.request.CategoryRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.mongodb.client.result.UpdateResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CategoryServiceImpl.class, HttpStatusCode.class, HttpStatusMessage.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private HttpStatusCode httpStatusCode;

    @Autowired
    private HttpStatusMessage httpStatusMessage;

    @MockBean
    private ModelRepository modelRepository;

    @MockBean
    private MongoTemplate mongoTemplate;

    @MockBean
    private SequenceGeneratorService sequenceGeneratorService;

    @Test
    void addCategory() {
    }

    /**
     * Method under test: {@link CategoryServiceImpl#addCategory(CategoryRequest)}
     */
    @Test
    void testAddCategory() {
        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(category);
        when(sequenceGeneratorService.generateSequence(Mockito.<String>any())).thenReturn("Generate Sequence");
        ResponseEntity actualAddCategoryResult = categoryServiceImpl
                .addCategory(new CategoryRequest("Category Name", "42"));
        assertNull(actualAddCategoryResult.getBody());
        assertNull(actualAddCategoryResult.getError());
        assertEquals(0, actualAddCategoryResult.getCode().intValue());
        verify(categoryRepository).save(Mockito.<Category>any());
        verify(sequenceGeneratorService).generateSequence(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#addCategory(CategoryRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddCategory2() {
        Category category = mock(Category.class);
        when(category.getCategoryName()).thenReturn("Category Name");
        doNothing().when(category).setCategoryId(Mockito.<String>any());
        doNothing().when(category).setCategoryName(Mockito.<String>any());
        doNothing().when(category).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(category).setParentCategoryId(Mockito.<String>any());
        doNothing().when(category).setStatus(Mockito.<String>any());
        doNothing().when(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(category);
        when(sequenceGeneratorService.generateSequence(Mockito.<String>any())).thenReturn("Generate Sequence");
        categoryServiceImpl.addCategory(null);
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getAllCategory()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCategory() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.ImmutableCollections$Map1.<init>(ImmutableCollections.java:1104)
        //       at java.base/java.util.Map.of(Map.java:1353)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.getAllCategory(CategoryServiceImpl.java:76)
        //   See https://diff.blue/R013 to resolve this issue.

        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        categoryServiceImpl.getAllCategory();
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getAllCategory()}
     */
    @Test
    void testGetAllCategory2() {
        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);

        ResponseEntity actualAllCategory = categoryServiceImpl.getAllCategory();
        assertEquals(1, ((Collection<Category>) actualAllCategory.getBody()).size());
        assertNull(actualAllCategory.getError());
        assertEquals(0, actualAllCategory.getCode().intValue());
        verify(categoryRepository).findAll();
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategoryById(String)}
     */
    @Test
    void testGetCategoryById() {
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        ArrayList<Category> categoryList = new ArrayList<>();
        Optional<List<Category>> ofResult = Optional.of(categoryList);
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        ResponseEntity actualCategoryById = categoryServiceImpl.getCategoryById("42");
        assertEquals(categoryList, actualCategoryById.getBody());
        assertNull(actualCategoryById.getError());
        assertEquals(0, actualCategoryById.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategoryById(String)}
     */
    @Test
    void testGetCategoryById2() {
        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        ResponseEntity actualCategoryById = categoryServiceImpl.getCategoryById("42");
        assertEquals(categoryList, actualCategoryById.getBody());
        assertNull(actualCategoryById.getError());
        assertEquals(0, actualCategoryById.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategoryById(String)}
     */
    @Test
    void testGetCategoryById3() {
        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        Category category2 = new Category();
        category2.setCategoryId("Category Id");
        category2.setCategoryName("com.bassure.ims.productservice.collection.Category");
        category2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category2.setParentCategoryId("Parent Category Id");
        category2.setStatus("com.bassure.ims.productservice.collection.Category");
        category2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category2);
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        ResponseEntity actualCategoryById = categoryServiceImpl.getCategoryById("42");
        assertEquals(categoryList, actualCategoryById.getBody());
        assertNull(actualCategoryById.getError());
        assertEquals(0, actualCategoryById.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategoryById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCategoryById4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.isPresent()" because "parentCategoryId" is null
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.getCategoryById(CategoryServiceImpl.java:83)
        //   See https://diff.blue/R013 to resolve this issue.

        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(null);
        categoryServiceImpl.getCategoryById("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategoryById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCategoryById5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.ImmutableCollections$Map1.<init>(ImmutableCollections.java:1104)
        //       at java.base/java.util.Map.of(Map.java:1353)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.getCategoryById(CategoryServiceImpl.java:97)
        //   See https://diff.blue/R013 to resolve this issue.

        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        Optional<List<Category>> emptyResult = Optional.empty();
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(emptyResult);
        categoryServiceImpl.getCategoryById("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategoryById(String)}
     */
    @Test
    void testGetCategoryById6() {
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        ArrayList<Category> categoryList = new ArrayList<>();
        Optional<List<Category>> ofResult = Optional.of(categoryList);
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        ResponseEntity actualCategoryById = categoryServiceImpl.getCategoryById(null);
        assertEquals(categoryList, actualCategoryById.getBody());
        assertNull(actualCategoryById.getError());
        assertEquals(0, actualCategoryById.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#editCategory(String, CategoryRequest)}
     */
    @Test
    void testEditCategory() {
        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        Optional<Category> ofResult = Optional.of(category);

        Category category2 = new Category();
        category2.setCategoryId("42");
        category2.setCategoryName("Category Name");
        category2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category2.setParentCategoryId("42");
        category2.setStatus("Status");
        category2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(category2);
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        ResponseEntity actualEditCategoryResult = categoryServiceImpl.editCategory("42",
                new CategoryRequest("Category Name", "42"));
        assertNull(actualEditCategoryResult.getBody());
        assertNull(actualEditCategoryResult.getError());
        assertEquals(0, actualEditCategoryResult.getCode().intValue());
        verify(categoryRepository).save(Mockito.<Category>any());
        verify(categoryRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#editCategory(String, CategoryRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditCategory2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.ImmutableCollections$Map1.<init>(ImmutableCollections.java:1104)
        //       at java.base/java.util.Map.of(Map.java:1353)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.editCategory(CategoryServiceImpl.java:113)
        //   See https://diff.blue/R013 to resolve this issue.

        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(category);
        Optional<Category> emptyResult = Optional.empty();
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(emptyResult);
        categoryServiceImpl.editCategory("42", new CategoryRequest("Category Name", "42"));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#editCategory(String, CategoryRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditCategory3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Source must not be null
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.editCategory(CategoryServiceImpl.java:106)
        //   See https://diff.blue/R013 to resolve this issue.

        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("Category Name");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("Status");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        Optional<Category> ofResult = Optional.of(category);

        Category category2 = new Category();
        category2.setCategoryId("42");
        category2.setCategoryName("Category Name");
        category2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category2.setParentCategoryId("42");
        category2.setStatus("Status");
        category2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(category2);
        when(categoryRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        categoryServiceImpl.editCategory("42", null);
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCategory() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.mongodb.client.result.UpdateResult.getModifiedCount()" because "result" is null
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.deleteCategory(CategoryServiceImpl.java:125)
        //   See https://diff.blue/R013 to resolve this issue.

        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(null);
        categoryServiceImpl.deleteCategory("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCategory2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.mongodb.client.result.UpdateResult.getModifiedCount()" because "result" is null
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.deleteCategory(CategoryServiceImpl.java:125)
        //   See https://diff.blue/R013 to resolve this issue.

        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("id");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("id");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(null);
        categoryServiceImpl.deleteCategory("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCategory3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.mongodb.client.result.UpdateResult.getModifiedCount()" because "result" is null
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.deleteCategory(CategoryServiceImpl.java:125)
        //   See https://diff.blue/R013 to resolve this issue.

        Category category = new Category();
        category.setCategoryId("42");
        category.setCategoryName("id");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("id");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        Category category2 = new Category();
        category2.setCategoryId("id");
        category2.setCategoryName("status");
        category2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category2.setParentCategoryId("id");
        category2.setStatus("status");
        category2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category2);
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(null);
        categoryServiceImpl.deleteCategory("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCategory4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.isPresent()" because "parentCategoryId" is null
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.getCategoryById(CategoryServiceImpl.java:83)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.deleteCategory(CategoryServiceImpl.java:120)
        //   See https://diff.blue/R013 to resolve this issue.

        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(null);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(null);
        categoryServiceImpl.deleteCategory("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCategory5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.ImmutableCollections$Map1.<init>(ImmutableCollections.java:1104)
        //       at java.base/java.util.Map.of(Map.java:1353)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.getCategoryById(CategoryServiceImpl.java:97)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.deleteCategory(CategoryServiceImpl.java:120)
        //   See https://diff.blue/R013 to resolve this issue.

        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        Optional<List<Category>> emptyResult = Optional.empty();
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(emptyResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(null);
        categoryServiceImpl.deleteCategory("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCategory6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.ImmutableCollections$Map1.<init>(ImmutableCollections.java:1104)
        //       at java.base/java.util.Map.of(Map.java:1353)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.deleteCategory(CategoryServiceImpl.java:129)
        //   See https://diff.blue/R013 to resolve this issue.

        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);

        Model model = new Model();
        model.setBrandId("42");
        model.setCategoryId("42");
        model.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        model.setModelId("42");
        model.setModelName("id");
        model.setSpecification(new HashMap<>());
        model.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Model> modelList = new ArrayList<>();
        modelList.add(model);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(modelList);
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(null);
        categoryServiceImpl.deleteCategory("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    void testDeleteCategory7() {
        Category category = mock(Category.class);
        when(category.getParentCategoryId()).thenReturn("42");
        doNothing().when(category).setCategoryId(Mockito.<String>any());
        doNothing().when(category).setCategoryName(Mockito.<String>any());
        doNothing().when(category).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(category).setParentCategoryId(Mockito.<String>any());
        doNothing().when(category).setStatus(Mockito.<String>any());
        doNothing().when(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        category.setCategoryId("42");
        category.setCategoryName("id");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("id");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        UpdateResult updateResult = mock(UpdateResult.class);
        when(updateResult.getModifiedCount()).thenReturn(3L);
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(updateResult);
        ResponseEntity actualDeleteCategoryResult = categoryServiceImpl.deleteCategory("42");
        assertNull(actualDeleteCategoryResult.getBody());
        assertNull(actualDeleteCategoryResult.getError());
        assertEquals(0, actualDeleteCategoryResult.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
        verify(category).getParentCategoryId();
        verify(category).setCategoryId(Mockito.<String>any());
        verify(category).setCategoryName(Mockito.<String>any());
        verify(category).setCreatedAt(Mockito.<LocalDateTime>any());
        verify(category).setParentCategoryId(Mockito.<String>any());
        verify(category).setStatus(Mockito.<String>any());
        verify(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        verify(modelRepository, atLeast(1)).findByCategoryId(Mockito.<String>any());
        verify(mongoTemplate).updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any());
        verify(updateResult).getModifiedCount();
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    void testDeleteCategory8() {
        Category category = mock(Category.class);
        when(category.getParentCategoryId()).thenReturn(null);
        doNothing().when(category).setCategoryId(Mockito.<String>any());
        doNothing().when(category).setCategoryName(Mockito.<String>any());
        doNothing().when(category).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(category).setParentCategoryId(Mockito.<String>any());
        doNothing().when(category).setStatus(Mockito.<String>any());
        doNothing().when(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        category.setCategoryId("42");
        category.setCategoryName("id");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("id");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        UpdateResult updateResult = mock(UpdateResult.class);
        when(updateResult.getModifiedCount()).thenReturn(3L);
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(updateResult);
        ResponseEntity actualDeleteCategoryResult = categoryServiceImpl.deleteCategory("42");
        assertNull(actualDeleteCategoryResult.getBody());
        assertNull(actualDeleteCategoryResult.getError());
        assertEquals(0, actualDeleteCategoryResult.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
        verify(category).getParentCategoryId();
        verify(category).setCategoryId(Mockito.<String>any());
        verify(category).setCategoryName(Mockito.<String>any());
        verify(category).setCreatedAt(Mockito.<LocalDateTime>any());
        verify(category).setParentCategoryId(Mockito.<String>any());
        verify(category).setStatus(Mockito.<String>any());
        verify(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        verify(modelRepository, atLeast(1)).findByCategoryId(Mockito.<String>any());
        verify(mongoTemplate).updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any());
        verify(updateResult).getModifiedCount();
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCategory9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.ImmutableCollections$Map1.<init>(ImmutableCollections.java:1104)
        //       at java.base/java.util.Map.of(Map.java:1353)
        //       at com.bassure.ims.productservice.serviceImpl.CategoryServiceImpl.deleteCategory(CategoryServiceImpl.java:129)
        //   See https://diff.blue/R013 to resolve this issue.

        Category category = mock(Category.class);
        when(category.getParentCategoryId()).thenReturn("42");
        doNothing().when(category).setCategoryId(Mockito.<String>any());
        doNothing().when(category).setCategoryName(Mockito.<String>any());
        doNothing().when(category).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(category).setParentCategoryId(Mockito.<String>any());
        doNothing().when(category).setStatus(Mockito.<String>any());
        doNothing().when(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        category.setCategoryId("42");
        category.setCategoryName("id");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("id");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        UpdateResult updateResult = mock(UpdateResult.class);
        when(updateResult.getModifiedCount()).thenReturn(0L);
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(updateResult);
        categoryServiceImpl.deleteCategory("42");
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    void testDeleteCategory10() {
        Category category = mock(Category.class);
        when(category.getParentCategoryId()).thenReturn("42");
        doNothing().when(category).setCategoryId(Mockito.<String>any());
        doNothing().when(category).setCategoryName(Mockito.<String>any());
        doNothing().when(category).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(category).setParentCategoryId(Mockito.<String>any());
        doNothing().when(category).setStatus(Mockito.<String>any());
        doNothing().when(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        category.setCategoryId("42");
        category.setCategoryName("id");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("id");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        UpdateResult updateResult = mock(UpdateResult.class);
        when(updateResult.getModifiedCount()).thenReturn(3L);
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(updateResult);
        ResponseEntity actualDeleteCategoryResult = categoryServiceImpl.deleteCategory(null);
        assertNull(actualDeleteCategoryResult.getBody());
        assertNull(actualDeleteCategoryResult.getError());
        assertEquals(0, actualDeleteCategoryResult.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
        verify(category).getParentCategoryId();
        verify(category).setCategoryId(Mockito.<String>any());
        verify(category).setCategoryName(Mockito.<String>any());
        verify(category).setCreatedAt(Mockito.<LocalDateTime>any());
        verify(category).setParentCategoryId(Mockito.<String>any());
        verify(category).setStatus(Mockito.<String>any());
        verify(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        verify(modelRepository, atLeast(1)).findByCategoryId(Mockito.<String>any());
        verify(mongoTemplate).updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any());
        verify(updateResult).getModifiedCount();
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(String)}
     */
    @Test
    void testDeleteCategory11() {
        Category category = mock(Category.class);
        when(category.getParentCategoryId()).thenReturn(null);
        doNothing().when(category).setCategoryId(Mockito.<String>any());
        doNothing().when(category).setCategoryName(Mockito.<String>any());
        doNothing().when(category).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(category).setParentCategoryId(Mockito.<String>any());
        doNothing().when(category).setStatus(Mockito.<String>any());
        doNothing().when(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        category.setCategoryId("42");
        category.setCategoryName("id");
        category.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        category.setParentCategoryId("42");
        category.setStatus("id");
        category.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        Optional<List<Category>> ofResult = Optional.of(new ArrayList<>());
        when(categoryRepository.findByParentCategoryId(Mockito.<String>any())).thenReturn(ofResult);
        when(modelRepository.findByCategoryId(Mockito.<String>any())).thenReturn(new ArrayList<>());
        UpdateResult updateResult = mock(UpdateResult.class);
        when(updateResult.getModifiedCount()).thenReturn(3L);
        when(mongoTemplate.updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any())).thenReturn(updateResult);
        ResponseEntity actualDeleteCategoryResult = categoryServiceImpl.deleteCategory(null);
        assertNull(actualDeleteCategoryResult.getBody());
        assertNull(actualDeleteCategoryResult.getError());
        assertEquals(0, actualDeleteCategoryResult.getCode().intValue());
        verify(categoryRepository).findAll();
        verify(categoryRepository).findByParentCategoryId(Mockito.<String>any());
        verify(category).getParentCategoryId();
        verify(category).setCategoryId(Mockito.<String>any());
        verify(category).setCategoryName(Mockito.<String>any());
        verify(category).setCreatedAt(Mockito.<LocalDateTime>any());
        verify(category).setParentCategoryId(Mockito.<String>any());
        verify(category).setStatus(Mockito.<String>any());
        verify(category).setUpdatedAt(Mockito.<LocalDateTime>any());
        verify(modelRepository, atLeast(1)).findByCategoryId(Mockito.<String>any());
        verify(mongoTemplate).updateFirst(Mockito.<Query>any(), Mockito.<UpdateDefinition>any(),
                Mockito.<Class<Object>>any());
        verify(updateResult).getModifiedCount();
    }

    @Test
    void getAllCategory() {
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void editCategory() {
    }

    @Test
    void deleteCategory() {
    }
}