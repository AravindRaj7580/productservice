package com.Aravind.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Category extends BaseModel {
//    long id;
    private String name;
    @OneToMany(mappedBy = "category")
    List<Product> products;
}
