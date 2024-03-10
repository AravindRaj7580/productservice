package com.Aravind.productservice.services;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.DTOs.GenericProductDTOLongId;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import com.Aravind.productservice.models.Product;
import com.Aravind.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    @Autowired
    public SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDTO getProductById(UUID id) throws NotFoundException, TestException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new NotFoundException("product that we are searching is not found");
        }
        return convertProductToGenericDTO(product.get());
    }

    @Override
    public GenericProductDTOLongId getProductByLongId(UUID id) throws NotFoundException, TestException {
        return null;
    }

    public GenericProductDTO convertProductToGenericDTO(Product product){
        if(product == null){
            return null;
        }
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setPrice(product.getPrice());
        genericProductDTO.setName(product.getTitle());
        genericProductDTO.setCategory(product.getCategory());
        genericProductDTO.setImage(product.getImage());
        genericProductDTO.setDescription(product.getDescription());
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO createProductDTO(GenericProductDTO genericProductDTO) throws NotFoundException {
        Product product = new Product();
        product.setTitle(genericProductDTO.getName());
        product.setPrice(genericProductDTO.getPrice());
        product.setImage(genericProductDTO.getImage());
        product.setCategory(genericProductDTO.getCategory());
        product.setDescription(genericProductDTO.getDescription());
        Product savedProduct = productRepository.save(product);
        if(savedProduct == null){
            throw new NotFoundException("product not saved and returned null");
        }
        return convertProductToGenericDTO(savedProduct);
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        for(Product product1 : products){
            genericProductDTOS.add(convertProductToGenericDTO(product1));
        }
        return genericProductDTOS;
    }

    @Override
    public GenericProductDTO deleteProductbyId(UUID id) throws TestException, NotFoundException {
        GenericProductDTO genericProductDTO =  getProductById(id);
        productRepository.deleteById(id);
        System.out.println(genericProductDTO);
        return genericProductDTO;
    }
}
