package com.github.bloomspes.buybook.exceptions;

import com.github.bloomspes.buybook.domain.ProductId;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(ProductId id) {
        super("Product not found: " + id);
    }
}
