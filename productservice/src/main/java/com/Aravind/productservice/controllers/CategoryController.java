package com.Aravind.productservice.controllers;

import com.Aravind.productservice.DTOs.ProductListResquestDTO;
import com.Aravind.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("{uuid}")
    public void getProductCategoryByUUID(@PathVariable("uuid") String uuid){

        categoryService.getCategory(uuid);
    }
    @GetMapping
    public void getAllProductsByCategory(@RequestBody ProductListResquestDTO productListResquestDTO){
        categoryService.getAllProductByCategory(productListResquestDTO.getUuid());
    }

}
