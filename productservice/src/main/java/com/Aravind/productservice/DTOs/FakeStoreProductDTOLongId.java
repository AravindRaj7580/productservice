package com.Aravind.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTOLongId {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;
}
