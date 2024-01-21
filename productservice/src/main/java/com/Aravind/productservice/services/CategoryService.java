package com.Aravind.productservice.services;

import com.Aravind.productservice.models.Category;
import com.Aravind.productservice.models.Product;
import com.Aravind.productservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public  CategoryService(CategoryRepository categoryRepository1){
        this.categoryRepository = categoryRepository1;
    }
//    @Transactional
    public void getCategory(String uuid){
        Optional<Category> category = categoryRepository.findById(UUID.fromString(uuid));
        Category returnedCategory = category.get();
        List<Product> products = returnedCategory.getProducts();
        System.out.print("hi"+products);
    }
    public void getAllProductByCategory(List<String> uuid){
        List<UUID> uuids = new ArrayList<>();
        for(String uuid1 : uuid){
            uuids.add(UUID.fromString(uuid1));
        }

        List<Category> categories = categoryRepository.findAllById(uuids);

        for(Category category : categories){
            for(Product product : category.getProducts()){
                System.out.println(product);
            }
        }
    }
}
