package com.Aravind.productservice.DTOs;

import com.Aravind.productservice.models.Category;
import com.Aravind.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FakeStoreProductDTO {
    private UUID id;
    private String title;
    private Price price;
    private Category category;
    private String description;
    private String image;
}
