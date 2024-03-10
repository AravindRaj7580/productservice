package com.Aravind.productservice.thirdPartyClients.fakeStore;

import com.Aravind.productservice.DTOs.FakeStoreProductDTO;
import com.Aravind.productservice.DTOs.FakeStoreProductDTOLongId;
import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FakeStoreProductClient {

    @Value("${fakestore.api.baseURL}")
    private String fakeStoreAPIBaseURL;

    @Value("${fakestore.api.product}")
    private String productPath;
    private String productURL = "https://fakestoreapi.com/products/{id}";
    private String genProductURL = "https://fakestoreapi.com/products";
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.baseURL}") String productURL,
                                  @Value("${fakestore.api.product}") String productPath){
        this.restTemplateBuilder = restTemplateBuilder;
        this.genProductURL = productURL + productPath;
        this.productURL = productURL + productPath + "/{id}";
    }

    public FakeStoreProductDTO getProductById(UUID id) throws NotFoundException, TestException {
        RestTemplate restTemplate =  restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response =  restTemplate.getForEntity(productURL, FakeStoreProductDTO.class,1);
        FakeStoreProductDTO fakeStoreProductDTO =  response.getBody();
        if(fakeStoreProductDTO == null){
            throw new TestException("Test check");
//            returnExceptionStatus();
        }else if(fakeStoreProductDTO == null){
            return null;
            //throw new NotFoundException("fakeStoreDTO not found");
        }
        return fakeStoreProductDTO;
    }

    public FakeStoreProductDTOLongId getProductByLongId(UUID id) throws NotFoundException, TestException {
        RestTemplate restTemplate =  restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTOLongId> response =  restTemplate.getForEntity(productURL, FakeStoreProductDTOLongId.class,1);
        FakeStoreProductDTOLongId fakeStoreProductDTO =  response.getBody();
        if(fakeStoreProductDTO == null){
            throw new TestException("Test check");
//            returnExceptionStatus();
        }else if(fakeStoreProductDTO == null){
            return null;
            //throw new NotFoundException("fakeStoreDTO not found");
        }
        return fakeStoreProductDTO;
    }

    public FakeStoreProductDTO createProductDTO(GenericProductDTO genericProductDTO){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(genProductURL, genericProductDTO, FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        return fakeStoreProductDTO;
    }

    public FakeStoreProductDTO[] getAllProducts() {
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(genProductURL, FakeStoreProductDTO[].class);
        FakeStoreProductDTO[] fakeStoreProductDTOS = response.getBody();
        return fakeStoreProductDTOS;
    }

    public FakeStoreProductDTO deleteProductbyId(UUID id) {
        RestTemplate restTemplate =  restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(productURL, HttpMethod.DELETE,null,FakeStoreProductDTO.class,id);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        return fakeStoreProductDTO;
    }
}
