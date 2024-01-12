package com.Aravind.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private long price;
    private String category;
    private String description;
    private String image;
}
