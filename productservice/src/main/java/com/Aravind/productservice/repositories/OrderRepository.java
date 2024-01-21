package com.Aravind.productservice.repositories;

import com.Aravind.productservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
}
