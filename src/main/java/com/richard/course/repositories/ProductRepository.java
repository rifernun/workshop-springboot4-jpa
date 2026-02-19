package com.richard.course.repositories;

import com.richard.course.entities.Category;
import com.richard.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
