package com.Aravind.productservice.services;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.DTOs.GenericProductDTOLongId;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;

import java.util.List;
import java.util.UUID;


public interface ProductService {
    public GenericProductDTO getProductById(UUID id) throws NotFoundException, TestException;
    GenericProductDTOLongId getProductByLongId(UUID id) throws NotFoundException, TestException;
    public GenericProductDTO createProductDTO(GenericProductDTO genericProductDTO) throws NotFoundException;
    public List<GenericProductDTO> getAllProducts();
    public GenericProductDTO deleteProductbyId(UUID id) throws TestException, NotFoundException;
}
