package com.Aravind.productservice.services;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.DTOs.SortValue;
import com.Aravind.productservice.models.Product;
import com.Aravind.productservice.repositories.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;
    public SearchService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Page<GenericProductDTO> search(String query, int pageSize, int pageNumber, List<SortValue> sortValues){
        Sort sort = Sort.by("title").ascending()
                .and(Sort.by("description").descending());

        for(SortValue sortValue : sortValues){
            if(sortValue.getOrder().equals("ascending")){
                sort = sort.by(sortValue.getQuery()).ascending();
            }else {
                sort = sort.by(sortValue.getQuery()).descending();
            }
        }

        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);

        Page<Product> productsPage = productRepository.findAllByTitleContaining(query, pageable);
        List<Product> products = productsPage.get().toList();
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();
        for(Product product : products){
            genericProductDTOS.add(mapProductIntoGenericProductDTO(product));
        }
        Page<GenericProductDTO> genericProductDTOPage = new PageImpl<GenericProductDTO>(genericProductDTOS, productsPage.getPageable(), productsPage.getTotalPages() );
        return genericProductDTOPage;
    }

    public GenericProductDTO mapProductIntoGenericProductDTO(Product product){
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setPrice(product.getPrice());
        genericProductDTO.setName(product.getTitle());
        genericProductDTO.setDescription(product.getDescription());
        genericProductDTO.setImage(product.getImage());
        genericProductDTO.setCategory(product.getCategory());
//        genericProductDTO.setId(product.ge);
        return genericProductDTO;
    }
}
