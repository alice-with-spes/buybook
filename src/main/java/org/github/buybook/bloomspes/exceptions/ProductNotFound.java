package org.github.buybook.bloomspes.exceptions;

import org.github.buybook.bloomspes.domain.ProductId;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(ProductId id) {
        super("Product not found: " + id);
    }
}
