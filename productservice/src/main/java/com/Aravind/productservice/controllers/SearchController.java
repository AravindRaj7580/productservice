package com.Aravind.productservice.controllers;

import com.Aravind.productservice.DTOs.GenericProductDTO;
import com.Aravind.productservice.DTOs.SearchRequestDTO;
import com.Aravind.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }
    @PostMapping
    public Page<GenericProductDTO> search(@RequestBody SearchRequestDTO searchRequestDTO){
        return searchService.search(searchRequestDTO.getQuery(), searchRequestDTO.getPageSize(), searchRequestDTO.getPageNumber(), searchRequestDTO.getSortValues());
    }
}
