package com.github.buybook.exceptions;

import com.github.buybook.domain.ProductId;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(ProductId id) {
        super("Product not found: " + id);
    }
}
