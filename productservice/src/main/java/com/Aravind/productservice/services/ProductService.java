package com.Aravind.productservice.services;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public GenericProductDTO getProductById(Long id) throws NotFoundException, TestException;
    public GenericProductDTO createProductDTO(GenericProductDTO genericProductDTO);
    public List<GenericProductDTO> getAllProducts();
    public GenericProductDTO deleteProductbyId(Long id);
}
