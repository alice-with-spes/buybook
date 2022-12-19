package com.github.buybook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.buybook.domain.Product;
import com.github.buybook.domain.ProductId;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
