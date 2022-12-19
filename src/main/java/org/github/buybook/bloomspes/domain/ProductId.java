package org.github.buybook.bloomspes.domain;

import jakarta.persistence.Column;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ProductId {
    @Column(name = "id")
    private Long value;

    private ProductId() {
    }

    public ProductId(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
