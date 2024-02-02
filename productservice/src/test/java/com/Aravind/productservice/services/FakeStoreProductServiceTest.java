package com.Aravind.productservice.services;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import com.Aravind.productservice.thirdPartyClients.fakeStore.FakeStoreProductClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductServiceTest {
    @Autowired
    private FakeStoreProductService fakeStoreProductService;
    @MockBean
    private FakeStoreProductClient fakeStoreProductClientMock;
@Test
    public void testGetProductByIdWhenClientReturnsNull() throws TestException, NotFoundException {
        when(fakeStoreProductClientMock.getProductById(any(UUID.class))).thenReturn(null);

        GenericProductDTO response = fakeStoreProductService.getProductById(UUID.fromString("1"));

        Assertions.assertNull(response);

//        Assertions.assertThrows(NotFoundException.class, () -> fakeStoreProductService.getProductById(1L));
    }
}
