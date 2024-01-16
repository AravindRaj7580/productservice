package com.Aravind.productservice.repositories;

import com.Aravind.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
