package com.Aravind.productservice.controllers;

import com.Aravind.productservice.DTOs.ExceptionDTO;
import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.DTOs.GenericProductDTOLongId;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import com.Aravind.productservice.security.JwtData;
import com.Aravind.productservice.security.TokenValidator;
import com.Aravind.productservice.services.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private TokenValidator tokenValidator;

    @Autowired
//    public ProductController(@Qualifier("fakeStoreService") ProductService productService){
//        this.productService = productService;
//    }
    public ProductController(@Qualifier("fakeStoreService") ProductService productService, TokenValidator tokenValidator){
        this.productService = productService;
        this.tokenValidator = tokenValidator;
    }


//    @GetMapping("{id}")
//    public GenericProductDTO getproductById(
//            @Nullable @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
//            @PathVariable("id") UUID id) throws NotFoundException, TestException {
//        System.out.println("Calling methods");
//        System.out.println("Calling methods again");
//        Optional<JwtData> jwtDataOptional = tokenValidator.validateToken(authToken);
//        if(jwtDataOptional.isPresent()){
//            //do whatever we wants
//        }
//        GenericProductDTO genericProductDTO = productService.getProductById(id);
//        if(genericProductDTO == null){
//            return new GenericProductDTO();
//        }
//        return genericProductDTO;
//    }

    @GetMapping("{id}")
    public GenericProductDTOLongId getproductById(
            @Nullable @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
            @PathVariable("id") UUID id) throws NotFoundException, TestException {
        System.out.println("Calling methods");
        System.out.println("Calling methods again");
        Optional<JwtData> jwtDataOptional = tokenValidator.validateToken(authToken);
        if(jwtDataOptional.isPresent()){
            //do whatever we wants
        }
        GenericProductDTOLongId genericProductDTO = productService.getProductByLongId(id);
        if(genericProductDTO == null){
            return new GenericProductDTOLongId();
        }
        return genericProductDTO;
    }

    @DeleteMapping("{id}")
    private GenericProductDTO deleteProductById(@PathVariable("id") UUID id) throws TestException, NotFoundException {
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
