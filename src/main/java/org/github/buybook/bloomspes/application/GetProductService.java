package org.github.buybook.bloomspes.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.github.buybook.bloomspes.domain.Product;
import org.github.buybook.bloomspes.domain.ProductId;
import org.github.buybook.bloomspes.exceptions.ProductNotFound;
import org.github.buybook.bloomspes.repositories.ProductRepository;

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
