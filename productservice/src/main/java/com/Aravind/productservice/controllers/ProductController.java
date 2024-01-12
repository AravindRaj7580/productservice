package com.Aravind.productservice.controllers;

import com.Aravind.productservice.DTOs.ExceptionDTO;
import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import com.Aravind.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("{id}")
    private GenericProductDTO getproductById(@PathVariable("id") long id) throws NotFoundException, TestException {
        return productService.getProductById(id);

    }

    @DeleteMapping("{id}")
    private GenericProductDTO deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductbyId(id);
    }

    @GetMapping
    private List<GenericProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    private void getCategorybyId(){

    }
    private void updateProductById(){

    }
    @PostMapping
    private GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO) throws NotFoundException {
        return productService.createProductDTO(genericProductDTO);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> returnExceptionStatus(){
        return new ResponseEntity<>(new ExceptionDTO(HttpStatus.NOT_FOUND, "requested element not found"), HttpStatus.NOT_IMPLEMENTED);
    }

}
