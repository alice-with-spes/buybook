package com.github.bloomspes.buybook.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.bloomspes.buybook.domain.Product;
import com.github.bloomspes.buybook.repositories.ProductRepository;

@Service
@Transactional(readOnly = true)
public class GetProductsService {
    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
