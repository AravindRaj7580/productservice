package com.Aravind.productservice.services;

import com.Aravind.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
@SpringBootTest
public class SelfProductServiceTest {
    @Autowired
    private SelfProductService selfProductService;
    @MockBean
    private ProductRepository productRepository;

}
