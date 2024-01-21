package com.Aravind.productservice.repositories;

import com.Aravind.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("priceReposiory")
public interface PriceRepository extends JpaRepository<Price, Long> {
}
