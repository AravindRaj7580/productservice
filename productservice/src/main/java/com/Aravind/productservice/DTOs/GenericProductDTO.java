package com.Aravind.productservice.DTOs;

import com.Aravind.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {
    private String name;
    private String image;
    private String description;
    private double price;
    private String category;
}
