package com.Aravind.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    @ManyToOne
    private Category category;
//    private double price;
    private String image;
//    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @OneToOne
    private Price price;
//    private int inventoryCount;

}
