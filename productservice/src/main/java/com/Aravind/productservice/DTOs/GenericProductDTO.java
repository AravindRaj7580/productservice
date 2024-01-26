package com.Aravind.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {
    private long id;
    private String name;
    private String image;
    private String description;
    private double price;
    private String category;
}
