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
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
//    public ProductController(@Qualifier("fakeStoreService") ProductService productService){
//        this.productService = productService;
//    }
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }


    @GetMapping("{id}")
    public GenericProductDTO getproductById(@PathVariable("id") UUID id) throws NotFoundException, TestException {
        System.out.println("Calling methods");
        System.out.println("Calling methods again");
        GenericProductDTO genericProductDTO = productService.getProductById(id);
        if(genericProductDTO == null){
            return new GenericProductDTO();
        }
        return genericProductDTO;
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
