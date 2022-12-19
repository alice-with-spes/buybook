package com.github.buybook.domain;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;

@Entity
@Table(name = "products")
public class Product {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ProductId id;

    private String title;

    private String publisher;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Product() {
    }

    @Builder
    public Product(ProductId id, String title, String publisher) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
    }

    public static Product fake(Long id) {
        return Product.builder()
                .id(new ProductId(id))
                .title("CODE")
                .publisher("Insight")
                .build();
    }
}
