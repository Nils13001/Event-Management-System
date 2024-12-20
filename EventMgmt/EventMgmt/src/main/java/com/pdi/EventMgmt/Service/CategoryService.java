package com.pdi.EventMgmt.Service;


import com.pdi.EventMgmt.Model.CategoryModel;
import com.pdi.EventMgmt.Model.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryModel categoryModel);

    CategoryResponse getCategoryById(int categoryId);

    List<CategoryResponse> getAllCategories();
}