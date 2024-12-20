package com.pdi.EventMgmt.Controller;


import com.pdi.EventMgmt.Model.ApiResponse;
import com.pdi.EventMgmt.Model.CategoryModel;
import com.pdi.EventMgmt.Model.CategoryResponse;
import com.pdi.EventMgmt.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    // public ResponseEntity<Event>
    //public ResponseEntity<CategoryResponse>
    //Standard Format

    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(@RequestBody CategoryModel categoryModel) {
        CategoryResponse categoryResponse = categoryService.createCategory(categoryModel);
        return new ResponseEntity<>(new ApiResponse<>(true, "Category created successfully", categoryResponse), HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategory(@PathVariable int categoryId) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(new ApiResponse<>(true, "Category fetched successfully", categoryResponse), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(new ApiResponse<>(true, "Categories fetched successfully", categories), HttpStatus.OK);
    }
}
