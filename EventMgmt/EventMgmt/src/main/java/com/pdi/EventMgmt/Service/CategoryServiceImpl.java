package com.pdi.EventMgmt.Service;

import com.pdi.EventMgmt.Entity.CategoryEntity;
import com.pdi.EventMgmt.Exception.CategoryNotFoundException;
import com.pdi.EventMgmt.Model.CategoryModel;
import com.pdi.EventMgmt.Model.CategoryResponse;
import com.pdi.EventMgmt.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse createCategory(CategoryModel categoryRequest) {
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(categoryRequest.getCategoryName());
        category = categoryRepository.save(category);
        return new CategoryResponse(category.getCategoryId(), category.getCategoryName());
    }

    @Override
    public CategoryResponse getCategoryById(int categoryId) {
        CategoryEntity category = categoryRepository.findByCategoryId(categoryId).orElseThrow(() -> new CategoryNotFoundException("No category with that id"));
        return new CategoryResponse(category.getCategoryId(), category.getCategoryName());
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryResponse(category.getCategoryId(), category.getCategoryName()))
                .collect(Collectors.toList());
    }
}
