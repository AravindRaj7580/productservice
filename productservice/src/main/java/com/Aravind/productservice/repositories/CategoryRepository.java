package com.Aravind.productservice.repositories;

import com.Aravind.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
