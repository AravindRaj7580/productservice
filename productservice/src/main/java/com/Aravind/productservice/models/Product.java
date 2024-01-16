package com.Aravind.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Product extends BaseModel {
    private String name;
    private String description;
    @ManyToOne
    private Category category;
    private double price;
    private String image;

}
