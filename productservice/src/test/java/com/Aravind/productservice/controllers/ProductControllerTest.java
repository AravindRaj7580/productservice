package com.Aravind.productservice.controllers;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import com.Aravind.productservice.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private  ProductController productController;
    @MockBean
    private ProductService  productServiceMock;

//    public ProductControllerTest(){
//        productServiceMock = Mockito.mock(ProductService.class);
//        productController = new ProductController(productServiceMock);
//    }
     @Test
     public void testGetProductByIdReturnsEmptyObjectWhenNoProductIdFound() throws TestException, NotFoundException {
        when(productServiceMock.getProductById(any(UUID.class))).thenReturn(new GenericProductDTO());
//        GenericProductDTO genericProductDTOResponse = productServiceMock.getProductById(1L);
         GenericProductDTO genericProductDTOResponse = productController.getproductById(UUID.fromString("123"));
        Assertions.assertNotNull(genericProductDTOResponse);
    }
@Test
    public void testGetProductByIDReturnsCorrectResponse() throws TestException, NotFoundException {
         GenericProductDTO expected = new GenericProductDTO();
         expected.setId(UUID.fromString("1"));
         expected.setName("IPhone");

         GenericProductDTO toBeReturned = new GenericProductDTO();
         toBeReturned.setId(UUID.fromString("1"));
         toBeReturned.setName("IPhone");

         when(productServiceMock.getProductById(any(UUID.class))).thenReturn(toBeReturned);

         GenericProductDTO genericProductDTOResonse = productController.getproductById(UUID.fromString("1"));

         Assertions.assertEquals(genericProductDTOResonse.getId(), expected.getId());
         Assertions.assertEquals(genericProductDTOResonse.getName(), expected.getName());

    }

}
