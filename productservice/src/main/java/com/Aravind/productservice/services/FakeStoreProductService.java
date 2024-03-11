package com.Aravind.productservice.services;

import com.Aravind.productservice.DTOs.FakeStoreProductDTO;
import com.Aravind.productservice.DTOs.FakeStoreProductDTOLongId;
import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.DTOs.GenericProductDTOLongId;
import com.Aravind.productservice.Exceptions.NotFoundException;
import com.Aravind.productservice.Exceptions.TestException;
import com.Aravind.productservice.thirdPartyClients.fakeStore.FakeStoreProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Service("fakeStoreService")
public class FakeStoreProductService implements ProductService{
    private String productURL = "https://fakestoreapi.com/products/{id}";
    private String createProductURL = "https://fakestoreapi.com/products";
    private String getAllProductURL = "https://fakestoreapi.com/products";
    private FakeStoreProductClient fakeStoreProductClient;

    private RestTemplate restTemplate;

    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient,
                                   RedisTemplate<String, Object> redisTemplate,
                                   RestTemplate restTemplate){
        this.fakeStoreProductClient = fakeStoreProductClient;
        this.redisTemplate = redisTemplate;
        this.restTemplate = restTemplate;
    }

    public GenericProductDTO convertFakeToGenericDTO(FakeStoreProductDTO fakeStoreProductDTO){
        if(fakeStoreProductDTO == null){
            return null;
        }
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setName(fakeStoreProductDTO.getTitle());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        return genericProductDTO;
    }

    public GenericProductDTOLongId convertFakeToGenericDTOLongId(FakeStoreProductDTOLongId fakeStoreProductDTO){
        if(fakeStoreProductDTO == null){
            return null;
        }
        GenericProductDTOLongId genericProductDTO = new GenericProductDTOLongId();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setName(fakeStoreProductDTO.getTitle());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        return genericProductDTO;
    }


    @Override
    public GenericProductDTO getProductById(UUID id) throws NotFoundException, TestException {
        Object userData = restTemplate.getForEntity("http://userservice/users/1", Object.class);
        GenericProductDTO genericProductDTOCache = (GenericProductDTO) redisTemplate.opsForValue().get(String.valueOf(1));
        if(genericProductDTOCache != null){
            return genericProductDTOCache;
        }
        GenericProductDTO genericProductDTO  =  convertFakeToGenericDTO(fakeStoreProductClient.getProductById(id));
        redisTemplate.opsForValue().set(String.valueOf(id), genericProductDTO);
        return genericProductDTO;
    }

    @Override
    public GenericProductDTOLongId getProductByLongId(UUID id) throws NotFoundException, TestException {
        GenericProductDTOLongId genericProductDTOCache = (GenericProductDTOLongId) redisTemplate.opsForValue().get(String.valueOf(1));
        if(genericProductDTOCache != null){
            return genericProductDTOCache;
        }
        GenericProductDTOLongId genericProductDTO  =  convertFakeToGenericDTOLongId(fakeStoreProductClient.getProductByLongId(id));
        redisTemplate.opsForValue().set(String.valueOf(id), genericProductDTO);
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO createProductDTO(GenericProductDTO genericProductDTO){
        GenericProductDTO genericProductDTO1 = convertFakeToGenericDTO(fakeStoreProductClient.createProductDTO(genericProductDTO));
        return genericProductDTO1;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        FakeStoreProductDTO[] fakeStoreProductDTOS = fakeStoreProductClient.getAllProducts();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            GenericProductDTO genericProductDTO = convertFakeToGenericDTO(fakeStoreProductDTO);
            genericProductDTOS.add(genericProductDTO);
        }
        return genericProductDTOS;
    }

    @Override
    public GenericProductDTO deleteProductbyId(UUID id) {
        return convertFakeToGenericDTO(fakeStoreProductClient.deleteProductbyId(id));
    }

}
