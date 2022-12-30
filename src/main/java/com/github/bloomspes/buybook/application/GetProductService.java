package com.github.bloomspes.buybook.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.bloomspes.buybook.domain.Product;
import com.github.bloomspes.buybook.domain.ProductId;
import com.github.bloomspes.buybook.exceptions.ProductNotFound;
import com.github.bloomspes.buybook.repositories.ProductRepository;

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
