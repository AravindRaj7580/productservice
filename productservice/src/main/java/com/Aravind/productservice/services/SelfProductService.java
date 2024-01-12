package com.Aravind.productservice.services;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException, TestException {
        return null;
    }

    @Override
    public GenericProductDTO createProductDTO(GenericProductDTO genericProductDTO) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO deleteProductbyId(Long id) {
        return null;
    }
}
