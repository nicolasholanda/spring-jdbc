package com.github.nicolasholanda.spring_jdbc.repository;

import com.github.nicolasholanda.spring_jdbc.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
