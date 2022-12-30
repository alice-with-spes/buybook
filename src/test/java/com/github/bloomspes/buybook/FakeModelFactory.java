package com.github.bloomspes.buybook;

import com.github.bloomspes.buybook.domain.Product;
import com.github.bloomspes.buybook.domain.ProductId;

public class FakeModelFactory {
    public static Product product(ProductId id, String title) {
        return Product.builder()
                .id(id)
                .title(title)
                .publisher("Insight")
                .build();
    }

    public static Product product(ProductId id) {
        return FakeModelFactory.product(id, "CODE");
    }

    public static Product product(Long id) {
        return FakeModelFactory.product(new ProductId(id));
    }

    public static Product product() {
        return FakeModelFactory.product(new ProductId(1L), "CODE");
    }
}
