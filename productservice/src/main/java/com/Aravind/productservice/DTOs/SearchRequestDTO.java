package com.Aravind.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDTO {
    private String query;
    private int pageNumber;
    private int pageSize;
    List<SortValue> sortValues;
}
