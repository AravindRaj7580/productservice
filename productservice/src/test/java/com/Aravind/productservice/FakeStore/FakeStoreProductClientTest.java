package com.Aravind.productservice.FakeStore;

import com.Aravind.productservice.DTOs.FakeStoreProductDTO;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import com.Aravind.productservice.thirdPartyClients.fakeStore.FakeStoreProductClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductClientTest {
    @Autowired
    private FakeStoreProductClient fakeStoreProductClient;
    @MockBean
    private RestTemplateBuilder restTemplateBuilder;
//    @MockBean
//    private RestTemplate restTemplate;
@Test
    public void testGetProductById() throws TestException, NotFoundException {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = new ResponseEntity<>(null, HttpStatus.OK);

        when(restTemplate.getForEntity(any(String.class), eq(FakeStoreProductDTO.class), 1L)).thenReturn(fakeStoreProductDTOResponseEntity);

        FakeStoreProductDTO response = fakeStoreProductClient.getProductById(1L);

        Assertions.assertNull(response);

    }

}
