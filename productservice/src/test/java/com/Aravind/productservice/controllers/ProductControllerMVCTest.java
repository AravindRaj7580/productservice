package com.Aravind.productservice.controllers;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
@Test
    public void testGetProductById() throws Exception {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(1L);
        genericProductDTO.setName("IPhone");

        when(productService.getProductById(1l)).thenReturn(genericProductDTO);

        ResultActions resultActions = mockMvc.perform(get("/products/1")).andExpect(status().is(200))
                .andExpect(content().json("{\"id\":1,\"name\":\"IPhone\",\"image\":null,\"description\":null,\"price\":0.0,\"category\":null}"))
                .andExpect(jsonPath("$.id").value(1L));
        String responseString = resultActions.andReturn().getResponse().getContentAsString();
    Assertions.assertEquals("{\"id\":1,\"name\":\"IPhone\",\"image\":null,\"description\":null,\"price\":0.0,\"category\":null}", responseString);
         GenericProductDTO genericProductDTO1 = objectMapper.readValue(responseString, GenericProductDTO.class);
         Assertions.assertNotNull(genericProductDTO1);
         Assertions.assertEquals(genericProductDTO1.getName(), "IPhone");
         System.out.println(objectMapper.writeValueAsString(genericProductDTO1));
//        System.out.println(responseString);
    }

}
