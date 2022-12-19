package com.github.buybook.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.buybook.domain.Product;
import com.github.buybook.domain.ProductId;
import com.github.buybook.exceptions.ProductNotFound;
import com.github.buybook.repositories.ProductRepository;

@Service
@Transactional(readOnly = true)
public class GetProductService {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(ProductId id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));
    }
}
