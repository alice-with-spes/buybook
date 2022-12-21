package org.github.buybook.bloomspes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.github.buybook.bloomspes.domain.Product;
import org.github.buybook.bloomspes.domain.ProductId;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
