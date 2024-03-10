package com.Aravind.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenericProductDTOLongId implements Serializable {
    private Long id;
    private String name;
    private String image;
    private String description;
    private String price;
    private String category;
}
