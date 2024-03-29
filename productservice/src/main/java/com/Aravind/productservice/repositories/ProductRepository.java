package com.Aravind.productservice.repositories;

import com.Aravind.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, UUID> {
//    Product findbyTitleAndPrice_currency(String name, double currency);
//    @Query(value = "select * from products where id = :title", nativeQuery = true)
//    Product abc(String title);

//    @Query(value = "select * from products where id = :title", nativeQuery = false)
//    Product abc(String title);
    Optional<Product> findById(UUID id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(UUID id);

    Page<Product> findAllByTitle(String title, Pageable pageable);

    Page<Product> findAllByTitleContaining(String title, Pageable pageable);


}
