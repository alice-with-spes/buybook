package org.github.buybook.bloomspes.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.github.buybook.bloomspes.domain.Product;
import org.github.buybook.bloomspes.repositories.ProductRepository;

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
