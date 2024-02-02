package com.Aravind.productservice.DTOs;

import com.Aravind.productservice.models.Category;
import com.Aravind.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericProductDTO {
    private UUID id;
    private String name;
    private String image;
    private String description;
    private Price price;
    private Category category;
}
