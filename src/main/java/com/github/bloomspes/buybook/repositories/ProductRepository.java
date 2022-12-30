package com.github.bloomspes.buybook.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.bloomspes.buybook.domain.Product;
import com.github.bloomspes.buybook.domain.ProductId;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
    Optional<Product> findById(Long productId);
}
